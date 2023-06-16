package springboot.checker.fr.shoppingCart.vo.checkout;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.shoppingCart.checkout.CreditCard;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.shoppingCart.vo.checkout.CreditCardChecker")
public class CreditCardChecker implements Checker<CreditCard> {

	@Override
	public void check(CreditCard vo) {
		
		checkVo(vo);
		
		checkCardNumber1(vo);
		checkCardNumber2(vo);
		checkCardNumber3(vo);
		checkCardNumber4(vo);
	}

	
	private void checkVo(CreditCard vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkCardNumber1(CreditCard vo) {
	}
	private void checkCardNumber2(CreditCard vo) {
	}
	private void checkCardNumber3(CreditCard vo) {
	}
	private void checkCardNumber4(CreditCard vo) {
	}
}
