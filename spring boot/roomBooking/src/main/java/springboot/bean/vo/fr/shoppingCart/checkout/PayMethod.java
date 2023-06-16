package springboot.bean.vo.fr.shoppingCart.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethod {

	private String name;
	private boolean needCreditCard;
	private CreditCard creditCard;
}
