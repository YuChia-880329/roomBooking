package springboot.trans.fr.receipt.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.CreditCardDto;
import springboot.bean.vo.fr.receipt.CreditCard;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.receipt.vo.CreditCardTrans")
public class CreditCardTrans implements VoWoTrans<CreditCard, CreditCardDto> {

	@Override
	public CreditCard dtoToVoImpl(CreditCardDto dto) {
		
		return CreditCard.builder()
				.cardNumber(dto.getCardNumber())
				.build();
	}
}
