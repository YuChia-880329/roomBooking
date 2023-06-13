package springboot.bean.obj.fr.home.repo.hotelRoomPages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Output {

	private int maxPage;
	private HotelRoomPage hotelRoomPage;
}