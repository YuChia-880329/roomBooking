package springboot.trans.fr.home.vo.search;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.vo.search.HotelRoomDto;
import springboot.bean.vo.fr.home.search.HotelRoom;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.home.vo.search.HotelRoomTrans")
public class HotelRoomTrans implements VoWoTrans<HotelRoom, HotelRoomDto> {

	@Override
	public HotelRoom dtoToVoImpl(HotelRoomDto dto) {
		
		return HotelRoom.builder()
				.roomId(dto.getRoomId())
				.imgUrl(dto.getImgUrl())
				.hotelName(dto.getHotelName())
				.sectionName(dto.getSectionName())
				.roomName(dto.getRoomName())
				.validNum(dto.getValidNum())
				.price(dto.getPrice())
				.hotelId(dto.getHotelId())
				.build();
	}
}
