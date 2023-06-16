package springboot.bean.vo.fr.receipt.show;

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
	private String hotelName;
	private String roomName;
	private String checkinDate;
	private String checkoutDate;
	private String checkinTime;
	private int num;
	private int price;
}
