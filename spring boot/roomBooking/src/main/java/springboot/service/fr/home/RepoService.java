package springboot.service.fr.home;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.OutputDto;
import springboot.bean.dto.fr.home.vo.HotelRoomDto;
import util.ImageUtil;

@Service("fr.home.RepoService")
public class RepoService {

	public List<HotelRoomDto> toHotelRoomsVo(OutputDto output){
		
		return toHotelRoomVos(output.getHotelRoomPage().getHotelRoomList().getHotelRooms());
	}
	private List<HotelRoomDto> toHotelRoomVos(List<springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.HotelRoomDto> hotelRooms){
		
		return hotelRooms.stream()
				.map(hotelRoom -> toHotelRoomVo(hotelRoom))
				.collect(Collectors.toList());
	}
	private HotelRoomDto toHotelRoomVo(springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.HotelRoomDto hotelRoom) {
		
		return HotelRoomDto.builder()
				.roomId(hotelRoom.getRoomId())
				.imgUrl(ImageUtil.getImgUrl(hotelRoom.getHotelId(), hotelRoom.getRoomId(), hotelRoom.getImgName()))
				.hotelName(hotelRoom.getHotelName())
				.sectionName(hotelRoom.getSectionName())
				.roomName(hotelRoom.getRoomName())
				.validNum(hotelRoom.getValidNum())
				.price(hotelRoom.getPrice())
				.hotelId(hotelRoom.getHotelId())
				.build();
	}
}
