package springboot.trans.bk.bookingOrderList.vo.allRooms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.allRooms.AllRoomsRespDto;
import springboot.bean.vo.bk.bookingOrderList.allRooms.AllRoomsResp;
import springboot.bean.vo.bk.bookingOrderList.allRooms.Room;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.bookingOrderList.vo.allRooms.AllRoomsRespTrans")
public class AllRoomsRespTrans implements VoWoTrans<AllRoomsResp, AllRoomsRespDto> {

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.allRooms.RoomTrans")
	private RoomTrans roomTrans;
	
	@Override
	public AllRoomsResp dtoToVoImpl(AllRoomsRespDto dto) {
		
		return AllRoomsResp.builder()
				.rooms(roomTrans.dtoListToVoArray(dto.getRooms(), size -> new Room[size]))
				.build();
	}
}
