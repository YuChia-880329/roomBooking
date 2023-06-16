package springboot.bean.dto.fr.shoppingCart.vo.turnPage;

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
public class TurnPageRespDto {

	private ItemListDto itemList;
	private PaginationDto pagination;
}
