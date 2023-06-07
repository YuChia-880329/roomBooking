package springboot.bean.dto.bk.roomUpdate.vo.allRooms;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllRoomsRespDto {

	private List<RoomDto> rooms;
}
