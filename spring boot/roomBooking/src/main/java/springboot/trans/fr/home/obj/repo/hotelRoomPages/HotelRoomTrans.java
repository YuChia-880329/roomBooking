package springboot.trans.fr.home.obj.repo.hotelRoomPages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.HotelRoomDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoom;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.home.obj.repo.homeRooms.HotelRoomTrans")
public class HotelRoomTrans extends RepoOutputTrans<HotelRoom, HotelRoomDto> {

	@Override
	protected HotelRoom dtoToOutputImpl(HotelRoomDto dto) {
		
		return HotelRoom.builder()
				.imgName(dto.getImgName())
				.hotelId(dto.getHotelId())
				.hotelName(dto.getHotelName())
				.sectionName(dto.getSectionName())
				.roomId(dto.getRoomId())
				.roomName(dto.getRoomName())
				.validNum(dto.getValidNum())
				.price(dto.getPrice())
				.build();
	}

	@Override
	protected HotelRoomDto outputToDtoImpl(HotelRoom output) {
		
		return HotelRoomDto.builder()
				.imgName(output.getImgName())
				.hotelName(output.getHotelName())
				.sectionName(output.getSectionName())
				.roomName(output.getRoomName())
				.validNum(output.getValidNum())
				.price(output.getPrice())
				.build();
	}
}
