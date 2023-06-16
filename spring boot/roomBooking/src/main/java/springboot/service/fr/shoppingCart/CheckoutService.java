package springboot.service.fr.shoppingCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutReqDto;
import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutRespDto;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;

@Service("fr.shoppingCart.CheckoutService")
public class CheckoutService {

	public static final String SUCCESS_MSG = "結帳成功";
	public static final String FAILURE_MSG = "結帳失敗";
	
	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao shoppingCartDbDao;
	
	
	public CheckoutRespDto checkout(CheckoutReqDto checkoutReq) {
		
		clear();
		boolean success = true;
		
		return CheckoutRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
	
	private void clear() {
		
		List<ItemDto> items = shoppingCartDbDao.searchAll();
		items.stream().forEach(item -> shoppingCartDbDao.delete(item.getItemId()));
	}
}
