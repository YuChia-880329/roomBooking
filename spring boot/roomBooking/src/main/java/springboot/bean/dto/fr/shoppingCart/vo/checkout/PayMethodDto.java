package springboot.bean.dto.fr.shoppingCart.vo.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethodDto {

	private int id;
	private boolean needCreditCard;
	private CreditCardDto creditCard;
}
