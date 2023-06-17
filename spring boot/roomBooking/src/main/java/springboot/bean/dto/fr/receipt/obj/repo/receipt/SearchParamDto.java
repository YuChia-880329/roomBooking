package springboot.bean.dto.fr.receipt.obj.repo.receipt;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchParamDto {

	private int page;
	private List<ShoppingCartItemDto> shoppingCartItems;
}
