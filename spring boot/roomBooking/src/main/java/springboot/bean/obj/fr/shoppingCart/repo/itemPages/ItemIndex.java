package springboot.bean.obj.fr.shoppingCart.repo.itemPages;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class ItemIndex {

	private int itemId;
	private int roomId;
}
