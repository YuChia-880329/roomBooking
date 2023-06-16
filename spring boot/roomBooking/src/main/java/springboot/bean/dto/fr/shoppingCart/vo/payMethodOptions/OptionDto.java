package springboot.bean.dto.fr.shoppingCart.vo.payMethodOptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class OptionDto {

	private int id;
	private String name;
	private boolean needCreditCard;
}
