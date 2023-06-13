package springboot.trans.fr.home.obj.repo.hotelRoomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.InputDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Input;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.home.obj.repo.homeRooms.InputTrans")
public class InputTrans extends RepoInputTrans<Input, InputDto> {

	@Autowired
	@Qualifier("fr.home.obj.repo.homeRooms.SearchParamTrans")
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
