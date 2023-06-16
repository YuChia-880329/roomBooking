package springboot.trans.fr.receipt.vo.show;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.show.CreditCardDto;
import springboot.bean.vo.fr.receipt.show.CreditCard;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.receipt.vo.show.CreditCardTrans")
public class CreditCardTrans implements VoWoTrans<CreditCard, CreditCardDto> {

	@Override
	public CreditCard dtoToVoImpl(CreditCardDto dto) {
		
		return CreditCard.builder()
				.cardNumber(dto.getCardNumber())
				.build();
	}
}
