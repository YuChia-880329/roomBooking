package springboot.trans.fr.shoppingCart.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.ItemListDto;
import springboot.bean.vo.fr.shoppingCart.Item;
import springboot.bean.vo.fr.shoppingCart.ItemList;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.ItemListTrans")
public class ItemListTrans implements VoWoTrans<ItemList, ItemListDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.ItemTrans")
	private ItemTrans itemTrans;

	
	@Override
	public ItemList dtoToVoImpl(ItemListDto dto) {
		
		return ItemList.builder()
				.items(itemTrans.dtoListToVoArray(dto.getItems(), size -> new Item[size]))
				.build();
	}
}
