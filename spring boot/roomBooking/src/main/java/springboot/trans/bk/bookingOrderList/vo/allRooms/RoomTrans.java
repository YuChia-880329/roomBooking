package springboot.trans.bk.bookingOrderList.vo.allRooms;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.allRooms.RoomDto;
import springboot.bean.vo.bk.bookingOrderList.allRooms.Room;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.bookingOrderList.vo.allRooms.RoomTrans")
public class RoomTrans implements VoWoTrans<Room, RoomDto> {

	@Override
	public Room dtoToVoImpl(RoomDto dto) {
		
		return Room.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
