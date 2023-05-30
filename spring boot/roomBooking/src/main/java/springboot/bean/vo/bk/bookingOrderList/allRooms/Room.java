package springboot.bean.vo.bk.bookingOrderList.allRooms;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Room {

	private int id;
	private String name;
}
