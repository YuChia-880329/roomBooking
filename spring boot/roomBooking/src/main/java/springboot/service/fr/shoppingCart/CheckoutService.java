package springboot.service.fr.shoppingCart;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

import springboot.bean.dto.fr.login.obj.status.login.LoginDto;
import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.bean.dto.fr.receipt.obj.db.receipts.ReceiptDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.CreditCardInputDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.InputDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.PayMethodInputDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.SearchParamDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.ShoppingCartItemDto;
import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutReqDto;
import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutRespDto;
import springboot.bean.dto.fr.shoppingCart.vo.checkout.CreditCardDto;
import springboot.bean.dto.fr.shoppingCart.vo.checkout.PayMethodDto;
import springboot.bean.dto.model.BookingOrderDto;
import springboot.dao.fr.login.memory.status.LoginStatusDao;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;
import springboot.dao.fr.receipt.memory.db.ReceiptsDbDao;
import springboot.dao.fr.receipt.memory.repo.ReceiptRepoDao;
import springboot.dao.model.inner.BookingOrderDaoInner;
import springboot.exception.NotLoginException;

@Service("fr.shoppingCart.CheckoutService")
@RequestScope
public class CheckoutService {

	public static final String SUCCESS_MSG = "結帳成功";
	public static final String FAILURE_MSG = "結帳失敗";
	
	public static int receiptIdCounter = 0;
	
	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao shoppingCartDbDao;
	@Autowired
	@Qualifier("model.inner.BookingOrderDaoInner")
	private BookingOrderDaoInner bookingOrderDaoInner;
	@Autowired
	@Qualifier("fr.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("fr.receipt.memory.db.ReceiptsDbDao")
	private ReceiptsDbDao receiptsDbDao;
	@Autowired
	@Qualifier("fr.receipt.memory.repo.ReceiptRepoDao")
	private ReceiptRepoDao receiptRepoDao;
	
	
	@Transactional
	public CheckoutRespDto checkout(CheckoutReqDto checkoutReq) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);

		List<ItemDto> items = shoppingCartDbDao.searchAll();
		
		createBookingOrders(items, login.getMemberId(), checkoutReq.getPayMethod().getId());
		int receiptId = createReceipt(items, checkoutReq.getPayMethod());
		boolean success = receiptId>=0;
		
		
		clearShoppingCart(items);
		return CheckoutRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.receiptRepoId(receiptId)
				.build();
	}
	
	public void createBookingOrders(List<ItemDto> items, int memberId, int payMethodId) {
		
		items.forEach(item -> {
			
			BookingOrderDto bookingOrder = BookingOrderDto.builder()
					.id(0)
					.clientId(memberId)
					.roomId(item.getRoomId())
					.roomNum(item.getNum())
					.payMethodId(payMethodId)
					.checkinDate(item.getCheckinDate())
					.checkoutDate(item.getCheckoutDate())
					.checkinTime(item.getCheckinTime())
					.useDay((int)item.getCheckinDate().until(item.getCheckoutDate(), ChronoUnit.DAYS))
					.totalMoney(item.getNum() * item.getPrice())
					.build();
			bookingOrderDaoInner.add(bookingOrder);
		});
	}
	
	private void clearShoppingCart(List<ItemDto> items) {
		
		items.stream().forEach(item -> shoppingCartDbDao.delete(item.getItemId()));
	}
	private int createReceipt(List<ItemDto> items, PayMethodDto payMethod) {
		
		receiptRepoDao.getObj(toInput(items, payMethod));
		
		ReceiptDto receipt = ReceiptDto.builder()
				.receiptId(receiptIdCounter++)
				.receiptRepoDao(receiptRepoDao)
				.build();
		receipt = receiptsDbDao.insert(receipt);
		return receipt!=null ? receipt.getReceiptId() : -1;
	}
	
	private InputDto toInput(List<ItemDto> items, PayMethodDto payMethod) {
		
		return InputDto.builder()
				.searchParam(toSearchParam(items))
				.totalPrice(toTotalPrice(items))
				.payMethodInput(toPayMethodInput(payMethod))
				.build();
	}
	private SearchParamDto toSearchParam(List<ItemDto> items) {
		
		return SearchParamDto.builder()
				.page(1)
				.shoppingCartItems(toShoppingCartItems(items))
				.build();
	}
	private List<ShoppingCartItemDto> toShoppingCartItems(List<ItemDto> items) {
		
		return items.stream()
				.map(item -> toShoppingCartItem(item))
				.collect(Collectors.toList());
	}
	private ShoppingCartItemDto toShoppingCartItem(ItemDto item) {
		
		return ShoppingCartItemDto.builder()
				.itemId(item.getItemId())
				.roomId(item.getRoomId())
				.checkinDate(item.getCheckinDate())
				.checkoutDate(item.getCheckoutDate())
				.checkinTime(item.getCheckinTime())
				.num(item.getNum())
				.price(item.getPrice())
				.build();
	}
	private PayMethodInputDto toPayMethodInput(PayMethodDto payMethod) {
		
		return PayMethodInputDto.builder()
				.id(payMethod.getId())
				.needCreditCard(payMethod.isNeedCreditCard())
				.creditCardInput(toCreditCardInput(payMethod.getCreditCard()))
				.build();
	}
	private CreditCardInputDto toCreditCardInput(CreditCardDto creditCard) {
		
		return CreditCardInputDto.builder()
				.cardNumber1(creditCard.getCardNumber1())
				.cardNumber2(creditCard.getCardNumber2())
				.cardNumber3(creditCard.getCardNumber3())
				.cardNumber4(creditCard.getCardNumber4())
				.build();
	}
	
	
	private int toTotalPrice(List<ItemDto> items) {
		
		return items.stream().collect(Collectors.summingInt(item -> item.getPrice()*item.getNum()));
	}
}
