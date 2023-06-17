package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.CreditCardInputDto;
import springboot.bean.obj.fr.receipt.repo.receipt.CreditCardInput;
import springboot.memory.repo.RepoInputTrans;

@Component("fr.receipt.obj.repo.receipt.CreditCardInputTrans")
public class CreditCardInputTrans extends RepoInputTrans<CreditCardInput, CreditCardInputDto> {

	@Override
	protected CreditCardInput dtoToInputImpl(CreditCardInputDto dto) {
		
		return CreditCardInput.builder()
				.cardNumber1(dto.getCardNumber1())
				.cardNumber2(dto.getCardNumber2())
				.cardNumber3(dto.getCardNumber3())
				.cardNumber4(dto.getCardNumber4())
				.build();
	}

	@Override
	protected CreditCardInputDto inputToDtoImpl(CreditCardInput output) {
		
		return CreditCardInputDto.builder()
				.cardNumber1(output.getCardNumber1())
				.cardNumber2(output.getCardNumber2())
				.cardNumber3(output.getCardNumber3())
				.cardNumber4(output.getCardNumber4())
				.build();
	}
}
