package springboot.bean.dto.fr.hotelPage.obj.repo.roomPages;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomListDto {

	private List<RoomDto> rooms;
}
