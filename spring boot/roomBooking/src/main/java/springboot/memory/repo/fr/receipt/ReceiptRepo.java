package springboot.memory.repo.fr.receipt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.PayMethodDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.obj.fr.receipt.repo.receipt.CreditCard;
import springboot.bean.obj.fr.receipt.repo.receipt.CreditCardInput;
import springboot.bean.obj.fr.receipt.repo.receipt.Input;
import springboot.bean.obj.fr.receipt.repo.receipt.Item;
import springboot.bean.obj.fr.receipt.repo.receipt.ItemList;
import springboot.bean.obj.fr.receipt.repo.receipt.ItemPage;
import springboot.bean.obj.fr.receipt.repo.receipt.Output;
import springboot.bean.obj.fr.receipt.repo.receipt.PayMethod;
import springboot.bean.obj.fr.receipt.repo.receipt.PayMethodInput;
import springboot.bean.obj.fr.receipt.repo.receipt.Receipt;
import springboot.bean.obj.fr.receipt.repo.receipt.SearchParam;
import springboot.bean.obj.fr.receipt.repo.receipt.ShoppingCartItem;
import springboot.dao.model.inner.PayMethodDaoInner;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.exception.IllegalPageException;
import springboot.memory.repo.Repo;
import util.PageUtil;
import util.StringConcatUtil;

@Component("fr.receipt.ReceiptRepo")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReceiptRepo extends Repo<Input, Receipt, Output> {

	public static final int ROWS_PER_PAGE = 6;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	@Autowired
	@Qualifier("model.inner.PayMethodDaoInner")
	private PayMethodDaoInner payMethodDaoInner;
	
	private boolean initialized;
	
	
	public ReceiptRepo() {
		
		this.initialized = false;
	}
	
	@Override
	protected Input initialInput() {
		
		return null;
	}

	@Override
	protected boolean isNeedUpdate(Input input) {
		
		return !initialized ||
				storeObj.getItemPageMap().get(input.getSearchParam().getPage()) == null;
	}

	@Override
	protected Receipt update(Input input) {
		
		if(input == null)
			return null;
		
		SearchParam searchParam = input.getSearchParam();
		int page = searchParam.getPage();

		int totalRows = searchParam.getShoppingCartItems().size();
		
		int maxPage = PageUtil.countMaxPage(ROWS_PER_PAGE, totalRows);
		int[] pageBounds = PageUtil.countPage(page, PAGES_PER_PAGE_GROUP, maxPage);
		
		if(pageBounds == null)
			throw new IllegalPageException(IllegalPageException.MSG);
		
		Map<Integer, ItemPage> itemPageMap = new HashMap<>();
		for(int p=pageBounds[0]; p<= pageBounds[1]; p++) {
			
			int[] rowBounds = PageUtil.countRow(ROWS_PER_PAGE, p);
			
			List<ShoppingCartItem> pageShoppingCartItems = searchParam.getShoppingCartItems().stream()
					.skip(rowBounds[0]-1)
					.limit(ROWS_PER_PAGE)
					.collect(Collectors.toList());
			List<Integer> roomIds = pageShoppingCartItems.stream()
					.map(shoppingCartItem -> shoppingCartItem.getRoomId())
					.collect(Collectors.toList());
			
			List<RoomDto> rooms = roomDaoInner.queryFrItemPages(roomIds);
			
			itemPageMap.put(p, toItemPage(pageShoppingCartItems, rooms, p));
		}
		
		if(!initialized)
			initialized = true;
		
		return Receipt.builder()
				.maxPage(maxPage)
				.itemPageMap(itemPageMap)
				.totalPrice(input.getTotalPrice())
				.payMethod(toPayMethod(input.getPayMethodInput()))
				.build();
	}

	@Override
	protected Output getOutput(Input input) {
		
		return Output.builder()
				.maxPage(storeObj.getMaxPage())
				.itemPage(storeObj.getItemPageMap().get(input.getSearchParam().getPage()))
				.totalPrice(input.getTotalPrice())
				.payMethod(toPayMethod(input.getPayMethodInput()))
				.build();
	}
	
	private ItemPage toItemPage(List<ShoppingCartItem> shoppingCartItems, List<RoomDto> rooms, int page) {
		
		return ItemPage.builder()
				.page(page)
				.itemList(toItemList(shoppingCartItems, rooms))
				.build();
	}
	private ItemList toItemList(List<ShoppingCartItem> shoppingCartItems, List<RoomDto> rooms) {
		
		return ItemList.builder()
				.items(toItems(shoppingCartItems, rooms))
				.build();
	}
	private List<Item> toItems(List<ShoppingCartItem> shoppingCartItems, List<RoomDto> rooms){
		
		return shoppingCartItems.stream()
				.map(shoppingCartItem -> toItem(shoppingCartItem, rooms))
				.collect(Collectors.toList());
	}
	private Item toItem(ShoppingCartItem shoppingCartItem, List<RoomDto> rooms){
		
		RoomDto room = null;
		for(int i=0; i<rooms.size(); i++) {
			
			if(rooms.get(i).getId() == shoppingCartItem.getRoomId()) {
				
				room = rooms.get(i);
				break;
			}	
		}
		
		return Item.builder()
				.itemId(shoppingCartItem.getItemId())
				.hotelName(room.getHotel().getName())
				.roomName(room.getName())
				.checkinDate(shoppingCartItem.getCheckinDate())
				.checkoutDate(shoppingCartItem.getCheckoutDate())
				.checkinTime(shoppingCartItem.getCheckinTime())
				.num(shoppingCartItem.getNum())
				.price(shoppingCartItem.getPrice())
				.build();
	}
	private PayMethod toPayMethod(PayMethodInput payMethodInput) {
		
		PayMethodDto payMethodDto = payMethodDaoInner.queryPayMethodById(payMethodInput.getId());
		return PayMethod.builder()
				.name(payMethodDto.getName())
				.needCreditCard(payMethodInput.isNeedCreditCard())
				.creditCard(toCreditCard(payMethodInput.getCreditCardInput()))
				.build();
	}
	private CreditCard toCreditCard(CreditCardInput creditCardInput) {
		
		return CreditCard.builder()
				.cardNumber(StringConcatUtil.concate(
						creditCardInput.getCardNumber1(), "-",
						creditCardInput.getCardNumber2(), "-",
						creditCardInput.getCardNumber3(), "-",
						creditCardInput.getCardNumber4()))
				.build();
	}
}
