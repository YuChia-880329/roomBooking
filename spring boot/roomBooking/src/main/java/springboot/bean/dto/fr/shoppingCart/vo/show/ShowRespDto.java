package springboot.bean.dto.fr.shoppingCart.vo.show;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.dto.fr.shoppingCart.vo.ItemListDto;
import springboot.bean.dto.vo.PaginationDto;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ShowRespDto {

	private ItemListDto itemList;
	private int totalPrice;
	private PaginationDto pagination;
}
