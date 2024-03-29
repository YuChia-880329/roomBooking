package springboot.trans.fr.receipt.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.PayMethodDto;
import springboot.bean.vo.fr.receipt.PayMethod;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.receipt.vo.PayMethodTrans")
public class PayMethodTrans implements VoWoTrans<PayMethod, PayMethodDto> {

	@Autowired
	@Qualifier("fr.receipt.vo.CreditCardTrans")
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
