package springboot.bean.dto.fr.hotelPage.vo.addShoppingCart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AddShoppingCartRespDto {

	private boolean success;
	private String msg;
}
