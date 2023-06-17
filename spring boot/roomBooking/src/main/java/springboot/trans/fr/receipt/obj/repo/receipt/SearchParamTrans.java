package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.SearchParamDto;
import springboot.bean.obj.fr.receipt.repo.receipt.SearchParam;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.receipt.obj.repo.receipt.SearchParamTrans")
public class SearchParamTrans extends RepoInputTrans<SearchParam, SearchParamDto> {

	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.ShoppingCartItemTrans")
	private ShoppingCartItemTrans shoppingCartItemTrans;
	
	
	@Override
	protected SearchParam dtoToInputImpl(SearchParamDto dto) {
		
		return SearchParam.builder()
				.page(dto.getPage())
				.shoppingCartItems(shoppingCartItemTrans.dtoListToInputList(dto.getShoppingCartItems()))
				.build();
	}

	@Override
	protected SearchParamDto inputToDtoImpl(SearchParam input) {
		
		return SearchParamDto.builder()
				.page(input.getPage())
				.shoppingCartItems(shoppingCartItemTrans.inputListToDtoList(input.getShoppingCartItems()))
				.build();
	}
}
