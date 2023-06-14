package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.InputDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Input;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.InputTrans")
public class InputTrans extends RepoInputTrans<Input, InputDto> {

	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.SearchParamTrans")
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
