package springboot.bean.dto.fr.home.obj.repo.hotelRoomPages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelRoomPageDto {

	private HotelRoomListDto hotelRoomList;
	private int page;
}
