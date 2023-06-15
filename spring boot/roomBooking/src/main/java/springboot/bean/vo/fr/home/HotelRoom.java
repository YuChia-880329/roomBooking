package springboot.bean.vo.fr.home;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelRoom {

	private int roomId;
	private String imgUrl;
	private String hotelName;
	private String sectionName;
	private String roomName;
	private int validNum;
	private int price;
	private int hotelId;
}
