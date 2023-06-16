package springboot.trans.fr.shoppingCart.vo.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.checkout.CreditCardDto;
import springboot.bean.vo.fr.shoppingCart.checkout.CreditCard;
import springboot.checker.fr.shoppingCart.vo.checkout.CreditCardChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.shoppingCart.vo.checkout.CreditCardTrans")
public class CreditCardTrans extends VoRiTransChecked<CreditCard, CreditCardDto, CreditCardChecker> {

	@Override
	public CreditCardDto voToDtoImpl(CreditCard vo) {
		
		return CreditCardDto.builder()
				.cardNumber1(vo.getCardNumber1())
				.cardNumber2(vo.getCardNumber2())
				.cardNumber3(vo.getCardNumber3())
				.cardNumber4(vo.getCardNumber4())
				.build();
	}
	
	
	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.CreditCardChecker")
	@Override
	public void setChecker(CreditCardChecker checker) {
		
		this.checker = checker;
	}
}
