package springboot.trans.fr.shoppingCart.obj.repo.itemPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.InputDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Input;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.shoppingCart.obj.repo.itemPages.InputTrans")
public class InputTrans extends RepoInputTrans<Input, InputDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.obj.repo.itemPages.SearchParamTrans")
	private SearchParamTrans searchParamTrans;
	
	
	@Override
	protected Input dtoToInputImpl(InputDto dto) {
		
		return Input.builder()
				.searchParam(searchParamTrans.dtoToInput(dto.getSearchParam()))
				.build();
	}

	@Override
	protected InputDto inputToDtoImpl(Input input) {
		
		return InputDto.builder()
				.searchParam(searchParamTrans.inputToDto(input.getSearchParam()))
				.build();
	}
}
