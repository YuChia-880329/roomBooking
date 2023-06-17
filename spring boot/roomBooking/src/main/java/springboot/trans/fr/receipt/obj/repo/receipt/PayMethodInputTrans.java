package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.PayMethodInputDto;
import springboot.bean.obj.fr.receipt.repo.receipt.PayMethodInput;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.receipt.obj.repo.receipt.PayMethodInputTrans")
public class PayMethodInputTrans extends RepoInputTrans<PayMethodInput, PayMethodInputDto> {

	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.CreditCardInputTrans")
	private CreditCardInputTrans creditCardInputTrans;
	
	@Override
	protected PayMethodInput dtoToInputImpl(PayMethodInputDto dto) {
		
		return PayMethodInput.builder()
				.id(dto.getId())
				.needCreditCard(dto.isNeedCreditCard())
				.creditCardInput(creditCardInputTrans.dtoToInput(dto.getCreditCardInput()))
				.build();
	}

	@Override
	protected PayMethodInputDto inputToDtoImpl(PayMethodInput input) {
		
		return PayMethodInputDto.builder()
				.id(input.getId())
				.needCreditCard(input.isNeedCreditCard())
				.creditCardInput(creditCardInputTrans.inputToDto(input.getCreditCardInput()))
				.build();
	}

}
