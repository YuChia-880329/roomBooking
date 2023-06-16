package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemListDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemList;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.ItemListTrans")
public class ItemListTrans extends RepoOutputTrans<ItemList, ItemListDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.ItemTrans")
	private ItemTrans itemTrans;

	
	@Override
	protected ItemList dtoToOutputImpl(ItemListDto dto) {
		
		return ItemList.builder()
				.items(itemTrans.dtoListToObjList(dto.getItems()))
				.build();
	}

	@Override
	protected ItemListDto outputToDtoImpl(ItemList output) {
		
		return ItemListDto.builder()
				.items(itemTrans.outputListToDtoList(output.getItems()))
				.build();
	}
}
