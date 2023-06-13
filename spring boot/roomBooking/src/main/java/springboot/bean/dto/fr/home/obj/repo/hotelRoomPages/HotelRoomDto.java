package springboot.bean.dto.fr.home.obj.repo.hotelRoomPages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelRoomDto {

	private String imgName;
	private int hotelId;
	private String hotelName;
	private String sectionName;
	private int roomId;
	private String roomName;
	private int validNum;
	private int price;
}
