package springboot.trans.fr.shoppingCart.vo.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.checkout.PayMethodDto;
import springboot.bean.vo.fr.shoppingCart.checkout.PayMethod;
import springboot.checker.fr.shoppingCart.vo.checkout.PayMethodChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.shoppingCart.vo.checkout.PayMethodTrans")
public class PayMethodTrans extends VoRiTransChecked<PayMethod, PayMethodDto, PayMethodChecker> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.CreditCardTrans")
	private CreditCardTrans creditCardTrans;
	
	
	@Override
	public PayMethodDto voToDtoImpl(PayMethod vo) {
		
		return PayMethodDto.builder()
				.id(vo.getId())
				.needCreditCard(vo.isNeedCreditCard())
				.creditCard(creditCardTrans.voToDto(vo.getCreditCard()))
				.build();
	}
	
	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.PayMethodChecker")
	@Override
	public void setChecker(PayMethodChecker checker) {
		
		this.checker = checker;
	}
}
