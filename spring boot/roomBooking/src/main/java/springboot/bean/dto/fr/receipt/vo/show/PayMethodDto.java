package springboot.bean.dto.fr.receipt.vo.show;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethodDto {

	private String name;
	private boolean needCreditCard;
	private CreditCardDto creditCard;
}
