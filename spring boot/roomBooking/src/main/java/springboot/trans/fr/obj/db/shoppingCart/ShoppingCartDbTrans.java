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
		
		return dto.getRoomId();
	}

	@Override
	protected Item dtoToObjImpl(ItemDto dto) {
		
		return Item.builder()
				.num(dto.getNum())
				.checkinTime(dto.getCheckinTime())
				.build();
	}

	@Override
	protected ItemDto paoToDtoImpl(PkAndObj<Integer, Item> pao) {
		
		return ItemDto.builder()
				.roomId(pao.getPk())
				.num(pao.getObj().getNum())
				.checkinTime(pao.getObj().getCheckinTime())
				.build();
	}
}
