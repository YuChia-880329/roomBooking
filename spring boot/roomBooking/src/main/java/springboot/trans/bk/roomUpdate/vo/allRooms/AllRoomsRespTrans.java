package springboot.trans.bk.roomUpdate.vo.allRooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.allRooms.AllRoomsRespDto;
import springboot.bean.vo.bk.roomUpdate.allRooms.AllRoomsResp;
import springboot.bean.vo.bk.roomUpdate.allRooms.Room;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.allRooms.AllRoomsRespTrans")
public class AllRoomsRespTrans implements VoWoTrans<AllRoomsResp, AllRoomsRespDto> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.allRooms.RoomTrans")
	private RoomTrans roomTrans;
	
	
	@Override
	public AllRoomsResp dtoToVoImpl(AllRoomsRespDto dto) {
		
		return AllRoomsResp.builder()
				.rooms(roomTrans.dtoListToVoArray(dto.getRooms(), size -> new Room[size]))
				.build();
	}
}
