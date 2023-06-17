package springboot.bean.obj.fr.receipt.repo.receipt;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchParam {

	private int page;
	private List<ShoppingCartItem> shoppingCartItems;
}
