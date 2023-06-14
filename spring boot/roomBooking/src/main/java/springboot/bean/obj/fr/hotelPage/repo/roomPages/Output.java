package springboot.bean.obj.fr.hotelPage.repo.roomPages;

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
	private RoomPage roomPage;
}
