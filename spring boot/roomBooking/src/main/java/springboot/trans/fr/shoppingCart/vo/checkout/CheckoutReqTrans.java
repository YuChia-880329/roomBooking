package springboot.trans.fr.shoppingCart.vo.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutReqDto;
import springboot.bean.vo.fr.shoppingCart.checkout.CheckoutReq;
import springboot.checker.fr.shoppingCart.vo.checkout.CheckoutReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.shoppingCart.vo.checkout.CheckoutReqTrans")
public class CheckoutReqTrans extends VoRiTransChecked<CheckoutReq, CheckoutReqDto, CheckoutReqChecker> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.PayMethodTrans")
	private PayMethodTrans payMethodTrans;

	
	@Override
	public CheckoutReqDto voToDtoImpl(CheckoutReq vo) {
		
		return CheckoutReqDto.builder()
				.payMethod(payMethodTrans.voToDto(vo.getPayMethod()))
				.build();
	}

	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.CheckoutReqChecker")
	@Override
	public void setChecker(CheckoutReqChecker checker) {
		
		this.checker = checker;
	}
}
