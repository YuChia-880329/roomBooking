package springboot.bean.obj.fr.home.repo.hotelRoomPages;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelRoomPages {

	private int maxPage;
	private Map<Integer, HotelRoomPage> hotelRoomPageMap;
}
