package springboot.bean.vo.fr.shoppingCart.show;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;
import springboot.bean.vo.Pagination;
import springboot.bean.vo.fr.shoppingCart.ItemList;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ShowResp extends Data {

	private ItemList itemList;
	private int totalPrice;
	private Pagination pagination;
}
