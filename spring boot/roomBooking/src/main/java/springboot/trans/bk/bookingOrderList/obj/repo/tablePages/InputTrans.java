package springboot.trans.bk.bookingOrderList.obj.repo.tablePages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.InputDto;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.Input;
import springboot.memory.repo.RepoInputTrans;

@Component("bk.bookingOrderList.obj.repo.tablePages.InputTrans")
public class InputTrans extends RepoInputTrans<Input, InputDto> {

	@Autowired
	@Qualifier("bk.bookingOrderList.obj.repo.tablePages.SearchParamTrans")
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
