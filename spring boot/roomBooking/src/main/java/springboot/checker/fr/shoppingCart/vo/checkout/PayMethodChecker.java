package springboot.checker.fr.shoppingCart.vo.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.shoppingCart.checkout.CreditCard;
import springboot.bean.vo.fr.shoppingCart.checkout.PayMethod;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.shoppingCart.vo.checkout.PayMethodChecker")
public class PayMethodChecker implements Checker<PayMethod> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.CreditCardChecker")
	private CreditCardChecker creditCardChecker;
	
	
	@Override
	public void check(PayMethod vo) {
		
		checkVo(vo);
		
		checkName(vo);
		checkNeedCreditCard(vo);
		checkCreditCard(vo);
	}
	
	private void checkVo(PayMethod vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkName(PayMethod vo) {
		
		String name = vo.getName();
		
		CheckUtil.checkString(name);
	}
	private void checkNeedCreditCard(PayMethod vo) {
	}
	private void checkCreditCard(PayMethod vo) {
		
		CreditCard creditCard = vo.getCreditCard();
		
		creditCardChecker.check(creditCard);
	}
}
