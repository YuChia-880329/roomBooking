package springboot.bean.vo.bk.bookingOrderList.allRooms;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllRoomsResp extends Data {

	private List<Room> rooms;
}
