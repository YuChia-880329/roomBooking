package springboot.bean.vo.fr.shoppingCart.delete;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class DeleteReq {

	private int itemId;
}
