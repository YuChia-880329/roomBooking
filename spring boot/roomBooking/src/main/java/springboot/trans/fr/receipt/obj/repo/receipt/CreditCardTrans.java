package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.CreditCardDto;
import springboot.bean.obj.fr.receipt.repo.receipt.CreditCard;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.receipt.obj.repo.receipt.CreditCardTrans")
public class CreditCardTrans extends RepoOutputTrans<CreditCard, CreditCardDto> {

	
	@Override
	protected CreditCard dtoToOutputImpl(CreditCardDto dto) {
		
		return CreditCard.builder()
				.cardNumber(dto.getCardNumber())
				.build();
	}

	@Override
	protected CreditCardDto outputToDtoImpl(CreditCard output) {
		
		return CreditCardDto.builder()
				.cardNumber(output.getCardNumber())
				.build();
	}
}
