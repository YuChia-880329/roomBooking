package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemIndexDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemIndex;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.ItemIndexTrans")
public class ItemIndexTrans extends RepoInputTrans<ItemIndex, ItemIndexDto> {

	@Override
	protected ItemIndex dtoToInputImpl(ItemIndexDto dto) {
		
		return ItemIndex.builder()
				.itemId(dto.getItemId())
				.roomId(dto.getRoomId())
				.build();
	}

	@Override
	protected ItemIndexDto inputToDtoImpl(ItemIndex input) {
		
		return ItemIndexDto.builder()
				.itemId(input.getItemId())
				.roomId(input.getRoomId())
				.build();
	}
}
