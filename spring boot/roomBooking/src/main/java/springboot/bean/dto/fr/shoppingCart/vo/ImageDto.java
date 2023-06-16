package springboot.bean.dto.fr.shoppingCart.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ImageDto {

	private int id;
	private String imgUrl;
}
