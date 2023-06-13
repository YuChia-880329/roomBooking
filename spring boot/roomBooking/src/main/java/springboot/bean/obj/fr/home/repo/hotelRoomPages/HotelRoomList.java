package springboot.bean.obj.fr.home.repo.hotelRoomPages;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelRoomList {

	private List<HotelRoom> hotelRooms;
}
