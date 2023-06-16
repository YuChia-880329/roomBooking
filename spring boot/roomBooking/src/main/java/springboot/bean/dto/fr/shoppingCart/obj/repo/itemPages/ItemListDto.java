package springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ItemListDto {

	private List<ItemDto> items;
}
