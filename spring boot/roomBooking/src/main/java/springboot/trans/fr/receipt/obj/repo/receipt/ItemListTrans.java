package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.ItemListDto;
import springboot.bean.obj.fr.receipt.repo.receipt.ItemList;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.receipt.obj.repo.receipt.ItemListTrans")
public class ItemListTrans extends RepoOutputTrans<ItemList, ItemListDto> {

	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.ItemTrans")
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
