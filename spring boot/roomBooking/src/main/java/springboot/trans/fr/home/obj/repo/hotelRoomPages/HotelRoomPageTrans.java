package springboot.trans.fr.home.obj.repo.hotelRoomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.HotelRoomPageDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomPage;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.home.obj.repo.homeRooms.HotelRoomPageTrans")
public class HotelRoomPageTrans extends RepoOutputTrans<HotelRoomPage, HotelRoomPageDto> {

	@Autowired
	@Qualifier("fr.home.obj.repo.homeRooms.HotelRoomListTrans")
	private HotelRoomListTrans hotelRoomListTrans;
	
	@Override
	protected HotelRoomPage dtoToOutputImpl(HotelRoomPageDto dto) {
		
		return HotelRoomPage.builder()
				.hotelRoomList(hotelRoomListTrans.dtoToObj(dto.getHotelRoomList()))
				.page(dto.getPage())
				.build();
	}

	@Override
	protected HotelRoomPageDto outputToDtoImpl(HotelRoomPage output) {
		
		return HotelRoomPageDto.builder()
				.hotelRoomList(hotelRoomListTrans.objToDto(output.getHotelRoomList()))
				.page(output.getPage())
				.build();
	}

}
