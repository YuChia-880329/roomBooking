package springboot.bean.obj.fr.shoppingCart.repo.itemPages;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ItemList {

	private List<Item> items;
}
