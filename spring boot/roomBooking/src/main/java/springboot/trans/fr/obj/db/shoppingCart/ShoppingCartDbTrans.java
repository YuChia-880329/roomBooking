package springboot.trans.fr.obj.db.shoppingCart;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto;
import springboot.bean.obj.fr.db.shoppingCart.Item;
import springboot.memory.db.MemoryDbTrans;
import springboot.memory.db.PkAndObj;

@Component("fr.obj.db.shoppingCart.ShoppingCartDbTrans")
public class ShoppingCartDbTrans extends MemoryDbTrans<Integer, Item, ItemDto> {

	@Override
	protected Integer dtoToPkImpl(ItemDto dto) {
		
		return dto.getItemId();
	}

	@Override
	protected Item dtoToObjImpl(ItemDto dto) {
		
		return Item.builder()
				.roomId(dto.getRoomId())
				.checkinDate(dto.getCheckinDate())
				.checkoutDate(dto.getCheckoutDate())
				.checkinTime(dto.getCheckinTime())
				.num(dto.getNum())
				.price(dto.getPrice())
				.build();
	}

	@Override
	protected ItemDto paoToDtoImpl(PkAndObj<Integer, Item> pao) {
		
		return ItemDto.builder()
				.itemId(pao.getPk())
				.roomId(pao.getObj().getRoomId())
				.checkinDate(pao.getObj().getCheckinDate())
				.checkoutDate(pao.getObj().getCheckoutDate())
				.checkinTime(pao.getObj().getCheckinTime())
				.num(pao.getObj().getNum())
				.price(pao.getObj().getPrice())
				.build();
	}
}
