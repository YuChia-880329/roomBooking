package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.RoomListDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.RoomList;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.RoomListTrans")
public class RoomListTrans extends RepoOutputTrans<RoomList, RoomListDto> {

	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.RoomTrans")
	private RoomTrans roomTrans;
	
	@Override
	protected RoomList dtoToOutputImpl(RoomListDto dto) {
		
		return RoomList.builder()
				.rooms(roomTrans.dtoListToObjList(dto.getRooms()))
				.build();
	}

	@Override
	protected RoomListDto outputToDtoImpl(RoomList output) {
		
		return RoomListDto.builder()
				.rooms(roomTrans.objListToDtoList(output.getRooms()))
				.build();
	}
}
