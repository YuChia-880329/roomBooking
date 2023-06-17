package springboot.trans.fr.receipt.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.ItemDto;
import springboot.bean.vo.fr.receipt.Item;
import tmpl.trans.bean.vo.VoWoTrans;
import util.DateTimeUtil;

@Component("fr.receipt.vo.ItemTrans")
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
