package springboot.bean.dto.fr.shoppingCart.vo.delete;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class DeleteReqDto {

	private int itemId;
}
