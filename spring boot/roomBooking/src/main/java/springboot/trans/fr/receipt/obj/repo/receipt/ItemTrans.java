package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.ItemDto;
import springboot.bean.obj.fr.receipt.repo.receipt.Item;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.receipt.obj.repo.receipt.ItemTrans")
public class ItemTrans extends RepoOutputTrans<Item, ItemDto> {
	
	@Override
	protected Item dtoToOutputImpl(ItemDto dto) {
		
		return Item.builder()
				.itemId(dto.getItemId())
				.hotelName(dto.getHotelName())
				.roomName(dto.getRoomName())
				.checkinDate(dto.getCheckinDate())
				.checkoutDate(dto.getCheckoutDate())
				.checkinTime(dto.getCheckinTime())
				.num(dto.getNum())
				.price(dto.getPrice())
				.build();
	}
	@Override
	protected ItemDto outputToDtoImpl(Item output) {
		
		return ItemDto.builder()
				.itemId(output.getItemId())
				.hotelName(output.getHotelName())
				.roomName(output.getRoomName())
				.checkinDate(output.getCheckinDate())
				.checkoutDate(output.getCheckoutDate())
				.checkinTime(output.getCheckinTime())
				.num(output.getNum())
				.price(output.getPrice())
				.build();
	}
}
