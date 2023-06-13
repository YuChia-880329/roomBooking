package springboot.bean.dto.fr.home.vo.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelRoomDto {

	private String imgUrl;
	private String hotelName;
	private String sectionName;
	private String roomName;
	private int validNum;
	private int price;
}
