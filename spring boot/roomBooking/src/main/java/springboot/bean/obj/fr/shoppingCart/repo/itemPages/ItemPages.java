package springboot.bean.obj.fr.shoppingCart.repo.itemPages;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ItemPages {

	private int maxPage;
	private Map<Integer, ItemPage> itemPageMap;
}
