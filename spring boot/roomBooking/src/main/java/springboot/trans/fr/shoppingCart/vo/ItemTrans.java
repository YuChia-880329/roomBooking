package springboot.trans.fr.shoppingCart.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.ItemDto;
import springboot.bean.vo.fr.shoppingCart.Image;
import springboot.bean.vo.fr.shoppingCart.Item;
import tmpl.trans.bean.vo.VoWoTrans;
import util.DateTimeUtil;

@Component("fr.shoppingCart.vo.ItemTrans")
public class ItemTrans implements VoWoTrans<Item, ItemDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.ImageTrans")
	private ImageTrans imageTrans;
	
	
	@Override
	public Item dtoToVoImpl(ItemDto dto) {
		
		return Item.builder()
				.itemId(dto.getItemId())
				.images(imageTrans.dtoListToVoArray(dto.getImages(), size -> new Image[size]))
				.hotelName(dto.getHotelName())
				.roomName(dto.getRoomName())
				.num(dto.getNum())
				.checkinDate(DateTimeUtil.toStringFront(dto.getCheckinDate()))
				.checkoutDate(DateTimeUtil.toStringFront(dto.getCheckoutDate()))
				.checkinTime(DateTimeUtil.toString(dto.getCheckinTime()))
				.price(dto.getPrice())
				.build();
	}
}
