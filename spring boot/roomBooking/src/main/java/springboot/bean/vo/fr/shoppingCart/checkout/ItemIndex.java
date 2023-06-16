package springboot.bean.vo.fr.shoppingCart.checkout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ItemIndex {

	private int itemId;
	private int roomId;
}
