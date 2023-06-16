package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Item;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.ItemTrans")
public class ItemTrans extends RepoOutputTrans<Item, ItemDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.ImageTrans")
	private ImageTrans imageTrans;
	
	
	@Override
	protected Item dtoToOutputImpl(ItemDto dto) {
		
		return Item.builder()
				.itemId(dto.getItemId())
				.images(imageTrans.dtoListToObjList(dto.getImages()))
				.hotelName(dto.getHotelName())
				.roomName(dto.getRoomName())
				.hotelId(dto.getHotelId())
				.build();
	}
	@Override
	protected ItemDto outputToDtoImpl(Item output) {
		
		return ItemDto.builder()
				.itemId(output.getItemId())
				.images(imageTrans.outputListToDtoList(output.getImages()))
				.hotelName(output.getHotelName())
				.roomName(output.getRoomName())
				.hotelId(output.getHotelId())
				.build();
	}
}
