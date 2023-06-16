package springboot.bean.vo.fr.shoppingCart.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CreditCard {

	private String cardNumber1;
	private String cardNumber2;
	private String cardNumber3;
	private String cardNumber4;
}
