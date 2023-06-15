package springboot.service.fr.hotelPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.hotelPage.vo.addShoppingCart.AddShoppingCartReqDto;
import springboot.bean.dto.fr.hotelPage.vo.addShoppingCart.AddShoppingCartRespDto;
import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;

@Service("fr.hotelPage.AddShoppingCartService")
public class AddShoppingCartService {

	public static final String SUCCESS_MSG = "已加入購物車";
	public static final String FAILURE_MSG = "加入購物車失敗";
	
	
	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao shoppingCartDbDao;
	
	
	public AddShoppingCartRespDto addShoppingCart(AddShoppingCartReqDto addShoppingCartReq) {
		
		ItemDto item = ItemDto.builder()
				.roomId(addShoppingCartReq.getRoomId())
				.checkinDate(addShoppingCartReq.getCheckinDate())
				.checkoutDate(addShoppingCartReq.getCheckoutDate())
				.checkinTime(addShoppingCartReq.getCheckinTime())
				.num(addShoppingCartReq.getNum())
				.build();
		if(shoppingCartDbDao.contains(item))
			item = shoppingCartDbDao.update(item);
		else
			item = shoppingCartDbDao.insert(item);
		
		boolean success = item!=null;
		return AddShoppingCartRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
}