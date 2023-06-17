package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.ItemPageDto;
import springboot.bean.obj.fr.receipt.repo.receipt.ItemPage;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.receipt.obj.repo.receipt.ItemPageTrans")
public class ItemPageTrans extends RepoOutputTrans<ItemPage, ItemPageDto> {

	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.ItemListTrans")
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
