package springboot.bean.dto.fr.hotelPage.obj.repo.roomPages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class OutputDto {

	private int maxPage;
	private RoomPageDto roomPage;
}
