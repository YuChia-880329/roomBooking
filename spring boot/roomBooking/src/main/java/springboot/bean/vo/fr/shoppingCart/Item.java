package springboot.bean.vo.fr.shoppingCart;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Item {

	private int itemId;
	private Image[] images;
	private String hotelName;
	private String roomName;
	private int num;
	private String checkinDate;
	private String checkoutDate;
	private String checkinTime;
	private int price;
}
