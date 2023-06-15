package springboot.bean.vo.fr.hotelPage.addShoppingCart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AddShoppingCartReq {

	private int roomId;
	private int num;
	private String checkinTime;
}
