package springboot.trans.bk.roomUpdate.vo.allRooms;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.allRooms.RoomDto;
import springboot.bean.vo.bk.roomUpdate.allRooms.Room;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.allRooms.RoomTrans")
public class RoomTrans implements VoWoTrans<Room, RoomDto> {

	@Override
	public Room dtoToVoImpl(RoomDto dto) {
		
		return Room.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
