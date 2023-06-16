package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.OutputDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Output;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.OutputTrans")
public class OutputTrans extends RepoOutputTrans<Output, OutputDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.ItemPageTrans")
	private ItemPageTrans itemPageTrans;
	
	
	@Override
	protected Output dtoToOutputImpl(OutputDto dto) {
		
		return Output.builder()
				.maxPage(dto.getMaxPage())
				.itemPage(itemPageTrans.dtoToObj(dto.getItemPage()))
				.build();
	}
	@Override
	protected OutputDto outputToDtoImpl(Output output) {
		
		return OutputDto.builder()
				.maxPage(output.getMaxPage())
				.itemPage(itemPageTrans.objToDto(output.getItemPage()))
				.build();
	}
}
