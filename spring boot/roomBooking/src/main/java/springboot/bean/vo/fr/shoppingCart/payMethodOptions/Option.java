package springboot.bean.vo.fr.shoppingCart.payMethodOptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Option {

	private int id;
	private String name;
	private boolean needCreditCard;
}
