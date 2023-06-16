package springboot.checker.fr.shoppingCart.vo.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.shoppingCart.checkout.CheckoutReq;
import springboot.bean.vo.fr.shoppingCart.checkout.PayMethod;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.shoppingCart.vo.checkout.CheckoutReqChecker")
public class CheckoutReqChecker implements Checker<CheckoutReq> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.PayMethodChecker")
	private PayMethodChecker payMethodChecker;
	
	@Override
	public void check(CheckoutReq vo) {
		
		checkVo(vo);
		
		checkPayMethod(vo);
	}

	private void checkVo(CheckoutReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkPayMethod(CheckoutReq vo) {
		
		PayMethod payMethod = vo.getPayMethod();
		
		payMethodChecker.check(payMethod);
	}
}
