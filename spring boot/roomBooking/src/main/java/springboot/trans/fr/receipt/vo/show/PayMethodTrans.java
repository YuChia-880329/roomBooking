package springboot.trans.fr.receipt.vo.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.show.PayMethodDto;
import springboot.bean.vo.fr.receipt.show.PayMethod;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.receipt.vo.show.PayMethodTrans")
public class PayMethodTrans implements VoWoTrans<PayMethod, PayMethodDto> {

	@Autowired
	@Qualifier("fr.receipt.vo.show.CreditCardTrans")
	private CreditCardTrans creditCardTrans;
	
	
	@Override
	public PayMethod dtoToVoImpl(PayMethodDto dto) {
		
		return PayMethod.builder()
				.name(dto.getName())
				.needCreditCard(dto.isNeedCreditCard())
				.creditCard(creditCardTrans.dtoToVo(dto.getCreditCard()))
				.build();
	}
}
