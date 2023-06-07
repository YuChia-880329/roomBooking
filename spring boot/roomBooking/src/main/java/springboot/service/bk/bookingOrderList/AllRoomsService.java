package springboot.service.bk.bookingOrderList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.bookingOrderList.vo.allRooms.AllRoomsRespDto;
import springboot.bean.dto.bk.bookingOrderList.vo.allRooms.RoomDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;

import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.bookingOrderList.AllRoomsService")
public class AllRoomsService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	
	
	public AllRoomsRespDto allRooms() {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		List<springboot.bean.dto.model.RoomDto> rooms = roomDaoInner.queryAllRoomsByHotelId(login.getHotelId());
		
		return AllRoomsRespDto.builder()
				.rooms(toRoomsVo(rooms))
				.build();
	}
	
	private List<RoomDto> toRoomsVo(List<springboot.bean.dto.model.RoomDto> rooms){
		
		return rooms.stream()
				.map(room -> toRoomVo(room))
				.collect(Collectors.toList());
	}
	private RoomDto toRoomVo(springboot.bean.dto.model.RoomDto room) {
		
		return RoomDto.builder()
				.id(room.getId())
				.name(room.getName())
				.build();
	}
}
