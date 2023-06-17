package springboot.trans.fr.receipt.obj.repo.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.repo.receipt.PayMethodDto;
import springboot.bean.obj.fr.receipt.repo.receipt.PayMethod;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.receipt.obj.repo.receipt.PayMethodOutputTrans")
public class PayMethodOutputTrans extends RepoOutputTrans<PayMethod, PayMethodDto> {

	@Autowired
	@Qualifier("fr.receipt.obj.repo.receipt.CreditCardTrans")
	private CreditCardTrans creditCardTrans;
	

	@Override
	protected PayMethod dtoToOutputImpl(PayMethodDto dto) {
		
		return PayMethod.builder()
				.name(dto.getName())
				.needCreditCard(dto.isNeedCreditCard())
				.creditCard(creditCardTrans.dtoToObj(dto.getCreditCard()))
				.build();
	}


	@Override
	protected PayMethodDto outputToDtoImpl(PayMethod output) {
		
		return PayMethodDto.builder()
				.name(output.getName())
				.needCreditCard(output.isNeedCreditCard())
				.creditCard(creditCardTrans.objToDto(output.getCreditCard()))
				.build();
	}
}
