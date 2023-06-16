package springboot.service.fr.hotelPage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.hotelPage.vo.addShoppingCart.AddShoppingCartReqDto;
import springboot.bean.dto.fr.hotelPage.vo.addShoppingCart.AddShoppingCartRespDto;
import springboot.bean.dto.fr.login.obj.status.login.LoginDto;
import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.dao.fr.login.memory.status.LoginStatusDao;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;
import springboot.exception.NotLoginException;

@Service("fr.hotelPage.AddShoppingCartService")
public class AddShoppingCartService {

	public static final String SUCCESS_MSG = "已加入購物車";
	public static final String FAILURE_MSG = "加入購物車失敗";
	
	private static int itemId = 0;
	
	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao shoppingCartDbDao;
	@Autowired
	@Qualifier("fr.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	public AddShoppingCartRespDto addShoppingCart(AddShoppingCartReqDto addShoppingCartReq) {
		
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		ItemDto item = ItemDto.builder()
				.itemId(-1)
				.roomId(addShoppingCartReq.getRoomId())
				.checkinDate(addShoppingCartReq.getCheckinDate())
				.checkoutDate(addShoppingCartReq.getCheckoutDate())
				.checkinTime(addShoppingCartReq.getCheckinTime())
				.num(addShoppingCartReq.getNum())
				.price(addShoppingCartReq.getPrice())
				.build();
		
		List<ItemDto> oldItems = shoppingCartDbDao.searchByRoomId(item.getRoomId());
		if(oldItems.size() == 0) {
			
			item.setItemId(itemId++);
			item = shoppingCartDbDao.insert(item);
		}else {
			
			ItemDto oldItem = getOldItem(oldItems, item);
			if(oldItem == null) {
				
				item.setItemId(itemId++);
				item = shoppingCartDbDao.insert(item);
			}else {
				
				oldItem.setNum(oldItem.getNum() + item.getNum());
				item = shoppingCartDbDao.update(oldItem);
			}
		}
		
		boolean success = (item!=null);
		return AddShoppingCartRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
	
	private boolean equals(ItemDto item1, ItemDto item2) {
		
		return item1.getRoomId()==item2.getRoomId() && 
				item1.getCheckinDate().equals(item2.getCheckinDate()) && 
				item1.getCheckoutDate().equals(item2.getCheckoutDate()) && 
				item1.getCheckinTime().equals(item2.getCheckinTime());
	}
	private ItemDto getOldItem(List<ItemDto> oldItems, ItemDto item) {
		
		int index = 0;
		for(; index<oldItems.size(); index++) {
			
			if(equals(item, oldItems.get(index)))
				break;
		}
		if(index < oldItems.size()) 
			return oldItems.get(index);
		else
			return null;
	}
}