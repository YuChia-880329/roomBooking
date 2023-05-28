package springboot.trans.bk.roomList.obj.repo.tablePages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.InputDto;
import springboot.bean.obj.bk.roomList.repo.tablePages.Input;
import springboot.memory.repo.RepoInputTrans;

@Component("bk.roomList.obj.repo.tablePages.InputTrans")
public class InputTrans extends RepoInputTrans<Input, InputDto> {

	@Autowired
	@Qualifier("bk.roomList.obj.repo.tablePages.SearchParamTrans")
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
