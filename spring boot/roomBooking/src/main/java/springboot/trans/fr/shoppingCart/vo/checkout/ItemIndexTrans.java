package springboot.trans.fr.shoppingCart.vo.checkout;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.checkout.ItemIndexDto;
import springboot.bean.vo.fr.shoppingCart.checkout.ItemIndex;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.checkout.ItemIndexTrans")
public class ItemIndexTrans implements VoWoTrans<ItemIndex, ItemIndexDto> {

	@Override
	public ItemIndex dtoToVoImpl(ItemIndexDto dto) {
		
		return ItemIndex.builder()
				.itemId(dto.getItemId())
				.roomId(dto.getRoomId())
				.build();
	}
}
