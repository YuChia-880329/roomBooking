package springboot.bean.vo.fr.shoppingCart.turnPage;

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
public class TurnPageResp extends Data {

	private ItemList itemList;
	private Pagination pagination;
}
