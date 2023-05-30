package springboot.bean.dto.bk.bookingOrderList.vo.allRooms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomDto {

	private int id;
	private String name;
}
