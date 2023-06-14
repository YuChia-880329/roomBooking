package springboot.bean.obj.fr.hotelPage.repo.roomPages;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomPages {

	private int maxPage;
	private Map<Integer, RoomPage> roomPageMap;
}
