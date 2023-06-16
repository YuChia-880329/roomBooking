package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemPageDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemPage;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.ItemPageTrans")
public class ItemPageTrans extends RepoOutputTrans<ItemPage, ItemPageDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.ItemListTrans")
	private ItemListTrans itemListTrans;
	
	
	@Override
	protected ItemPage dtoToOutputImpl(ItemPageDto dto) {
		
		return ItemPage.builder()
				.page(dto.getPage())
				.itemList(itemListTrans.dtoToObj(dto.getItemList()))
				.build();
	}
	@Override
	protected ItemPageDto outputToDtoImpl(ItemPage output) {
		
		return ItemPageDto.builder()
				.page(output.getPage())
				.itemList(itemListTrans.objToDto(output.getItemList()))
				.build();
	}
}
