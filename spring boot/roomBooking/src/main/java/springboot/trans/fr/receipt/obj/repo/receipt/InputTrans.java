package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.InputDto;
import springboot.bean.obj.fr.receipt.repo.receipt.Input;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.receipt.obj.repo.receipt.InputTrans")
public class InputTrans extends RepoInputTrans<Input, InputDto> {

	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.SearchParamTrans")
	private SearchParamTrans searchParamTrans;
	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.PayMethodInputTrans")
	private PayMethodInputTrans payMethodInputTrans;
	
	
	@Override
	protected Input dtoToInputImpl(InputDto dto) {
		
		return Input.builder()
				.searchParam(searchParamTrans.dtoToInput(dto.getSearchParam()))
				.totalPrice(dto.getTotalPrice())
				.payMethodInput(payMethodInputTrans.dtoToInput(dto.getPayMethodInput()))
				.build();
	}

	@Override
	protected InputDto inputToDtoImpl(Input input) {
		
		return InputDto.builder()
				.searchParam(searchParamTrans.inputToDto(input.getSearchParam()))
				.totalPrice(input.getTotalPrice())
				.payMethodInput(payMethodInputTrans.inputToDto(input.getPayMethodInput()))
				.build();
	}
}
