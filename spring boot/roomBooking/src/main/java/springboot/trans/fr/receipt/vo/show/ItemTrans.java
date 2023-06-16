package springboot.trans.fr.receipt.vo.show;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.show.ItemDto;
import springboot.bean.vo.fr.receipt.show.Item;
import tmpl.trans.bean.vo.VoWoTrans;
import util.DateTimeUtil;

@Component("fr.receipt.vo.show.ItemTrans")
public class ItemTrans implements VoWoTrans<Item, ItemDto> {

	@Override
	public Item dtoToVoImpl(ItemDto dto) {
		
		return Item.builder()
				.itemId(dto.getItemId())
				.hotelName(dto.getHotelName())
				.roomName(dto.getRoomName())
				.checkinDate(DateTimeUtil.toStringFront(dto.getCheckinDate()))
				.checkoutDate(DateTimeUtil.toStringFront(dto.getCheckoutDate()))
				.checkinTime(DateTimeUtil.toString(dto.getCheckinTime()))
				.num(dto.getNum())
				.price(dto.getPrice())
				.build();
	}
}
