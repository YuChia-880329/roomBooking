package springboot.service.bk.roomUpdate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomImgDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomInfoReqDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomInfoRespDto;
import springboot.bean.dto.model.RoomDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.exception.NotLoginException;
import util.ImageUtil;

@Service("bk.roomUpdate.RoomInfoService")
public class RoomInfoService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	
	public RoomInfoRespDto roomInfo(RoomInfoReqDto roomInfoReq) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		RoomDto room = roomDaoInner.queryRoomById(roomInfoReq.getRoomId()).get();
		
		return RoomInfoRespDto.builder()
				.totalNum(room.getTotalNum())
				.usedNum(room.getUsedNum())
				.invalidNum(room.getInvalidNum())
				.price(room.getPrice())
				.singleBedNum(room.getSingleBedNum())
				.doubleBedNum(room.getDoubleBedNum())
				.area(room.getArea())
				.sceneId(room.getSceneId())
				.showerIds(room.getShowers().stream()
						.map(shower -> shower.getId())
						.collect(Collectors.toList()))
				.status(room.getStatus())
				.imgs(toRoomImgsVo(room.getRoomImgs(), login.getHotelId(), room.getId()))
				.build();
	}
	
	private List<RoomImgDto> toRoomImgsVo(List<springboot.bean.dto.model.RoomImgDto> roomImgs, int hotelId, int roomId) {
		
		return roomImgs.stream().map(roomImg -> toRoomImgVo(roomImg, hotelId, roomId)).collect(Collectors.toList());
	}
	private RoomImgDto toRoomImgVo(springboot.bean.dto.model.RoomImgDto roomImg, int hotelId, int roomId) {
		
		return RoomImgDto.builder()
				.imgName(roomImg.getImageName())
				.url(ImageUtil.getImgUrl(hotelId, roomId, roomImg.getImageName()))
				.order(roomImg.getImageOrder())
				.build();
	}
}
