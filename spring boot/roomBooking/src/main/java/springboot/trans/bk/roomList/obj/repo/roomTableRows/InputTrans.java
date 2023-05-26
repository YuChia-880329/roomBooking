package springboot.trans.bk.roomList.obj.repo.roomTableRows;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.InputDto;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.Input;
import springboot.memory.repo.RepoInputTrans;

@Component
public class InputTrans extends RepoInputTrans<Input, InputDto> {

	@Autowired
	private SearchParamTrans searchParamTrans;
	
	@Override
	protected Input dtoToInputImpl(InputDto dto) {
		
		return Input.builder()
				.searchParam(searchParamTrans.dtoToInput(dto.getSearchParam()))
				.build();
	}

	@Override
	protected InputDto inputToDtoImpl(Input inputObj) {
		
		return InputDto.builder()
				.searchParam(searchParamTrans.inputToDto(inputObj.getSearchParam()))
				.build();
	}
}
