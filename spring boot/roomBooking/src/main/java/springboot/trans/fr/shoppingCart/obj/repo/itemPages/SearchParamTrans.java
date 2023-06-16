package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.SearchParamDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.SearchParam;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.SearchParamTrans")
public class SearchParamTrans extends RepoInputTrans<SearchParam, SearchParamDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.ItemIndexTrans")
	private ItemIndexTrans itemIndexTrans;
	
	
	@Override
	protected SearchParam dtoToInputImpl(SearchParamDto dto) {
		
		return SearchParam.builder()
				.page(dto.getPage())
				.itemIndices(itemIndexTrans.dtoListToInputList(dto.getItemIndices()))
				.build();
	}

	@Override
	protected SearchParamDto inputToDtoImpl(SearchParam input) {
		
		return SearchParamDto.builder()
				.page(input.getPage())
				.itemIndices(itemIndexTrans.inputListToDtoList(input.getItemIndices()))
				.build();
	}
}
