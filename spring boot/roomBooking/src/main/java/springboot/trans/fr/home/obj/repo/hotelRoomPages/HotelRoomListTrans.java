package springboot.trans.fr.home.obj.repo.hotelRoomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.HotelRoomListDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomList;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.home.obj.repo.homeRooms.HotelRoomListTrans")
public class HotelRoomListTrans extends RepoOutputTrans<HotelRoomList, HotelRoomListDto> {

	@Autowired
	@Qualifier("fr.home.obj.repo.homeRooms.HotelRoomTrans")
	private HotelRoomTrans hotelRoomTrans;
	
	@Override
	protected HotelRoomList dtoToOutputImpl(HotelRoomListDto dto) {
		
		return HotelRoomList.builder()
				.hotelRooms(hotelRoomTrans.dtoListToObjList(dto.getHotelRooms()))
				.build();
	}

	@Override
	protected HotelRoomListDto outputToDtoImpl(HotelRoomList output) {
		
		return HotelRoomListDto.builder()
				.hotelRooms(hotelRoomTrans.objListToDtoList(output.getHotelRooms()))
				.build();
	}
}
