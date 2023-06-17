package springboot.bean.obj.fr.receipt.repo.receipt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethodInput {

	private int id;
	private boolean needCreditCard;
	private CreditCardInput creditCardInput;
}
