package springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ItemPagesDto {

	private int maxPage;
	private Map<Integer, ItemPageDto> itemPageMap;
}
