package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.RoomPageDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.RoomPage;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.RoomPageTrans")
public class RoomPageTrans extends RepoOutputTrans<RoomPage, RoomPageDto> {

	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.RoomListTrans")
	private RoomListTrans roomListTrans;
	
	@Override
	protected RoomPage dtoToOutputImpl(RoomPageDto dto) {
		
		return RoomPage.builder()
				.roomList(roomListTrans.dtoToObj(dto.getRoomList()))
				.page(dto.getPage())
				.build();
	}

	@Override
	protected RoomPageDto outputToDtoImpl(RoomPage output) {
		
		return RoomPageDto.builder()
				.roomList(roomListTrans.objToDto(output.getRoomList()))
				.page(output.getPage())
				.build();
	}

}
