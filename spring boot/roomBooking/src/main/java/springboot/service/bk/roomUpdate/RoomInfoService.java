package springboot.service.bk.roomUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.ImageOrderDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.InvalidNumDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomImgDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomImgsDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomInfoReqDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomInfoRespDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.SceneDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.ShowerDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.StatusDto;
import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.UsedNumDto;
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
		
		boolean hasValue = true;
		RoomDto room = null;
		if(roomInfoReq.getRoomId() < 0)
			hasValue = false;
		else
			room = roomDaoInner.queryRoomById(roomInfoReq.getRoomId()).orElse(null);
		
		
		return RoomInfoRespDto.builder()
				.roomName(hasValue ? room.getName() : "")
				.totalNum(hasValue ? room.getTotalNum() : -1)
				.usedNum(toUsedNumVo(room, hasValue))
				.invalidNum(toInvalidNumVo(room, hasValue))
				.price(hasValue ? room.getPrice() : -1)
				.singleBedNum(hasValue ? room.getSingleBedNum() : -1)
				.doubleBedNum(hasValue ? room.getDoubleBedNum() : -1)
				.area(hasValue ? room.getArea() : -1)
				.scene(toSceneVo(room, hasValue))
				.shower(toShowerVo(room, hasValue))
				.status(toStatusVo(room, hasValue))
				.roomImgs(toRoomImgsVo(room, hasValue, login.getHotelId()))
				.imageOrder(toImageOrderVo(room, hasValue))
				.build();
	}
	
	private UsedNumDto toUsedNumVo(RoomDto room, boolean hasValue) {
		
		return UsedNumDto.builder()
				.hasValue(hasValue)
				.options(Stream.iterate(0, v -> v+1)
						.limit(hasValue ? room.getTotalNum()+1 : 0)
						.collect(Collectors.toList()))
				.value(hasValue ? room.getUsedNum() : 0)
				.build();
	}
	private InvalidNumDto toInvalidNumVo(RoomDto room, boolean hasValue) {
		
		return InvalidNumDto.builder()
				.hasValue(hasValue)
				.options(Stream.iterate(0, v -> v+1)
						.limit(hasValue ? room.getTotalNum()-room.getUsedNum()+1 : 0)
						.collect(Collectors.toList()))
				.value(hasValue ? room.getInvalidNum() : 0)
				.build();
	}
	private SceneDto toSceneVo(RoomDto room, boolean hasValue) {
		
		return SceneDto.builder()
				.able(hasValue)
				.sceneId(hasValue ? room.getSceneId() : 0)
				.build();
	}
	private ShowerDto toShowerVo(RoomDto room, boolean hasValue) {
		
		return ShowerDto.builder()
				.able(hasValue)
				.showerIds(hasValue ? room.getShowers().stream()
						.map(shower -> shower.getId())
						.collect(Collectors.toList()) : new ArrayList<>())
				.build();
	}
	private StatusDto toStatusVo(RoomDto room, boolean hasValue) {
		
		return StatusDto.builder()
				.able(hasValue)
				.statusId(hasValue ? room.getStatus().getCode() : 0)
				.build();
	}
	private RoomImgsDto toRoomImgsVo(RoomDto room, boolean hasValue, int hotelId) {
		

		return RoomImgsDto.builder()
				.hasImg(hasValue)
				.imgs(hasValue ? toRoomImgVos(room.getRoomImgs(), room.getId(), hotelId) : new ArrayList<>())
				.currentImg(hasValue ? toRoomImgVo(leastOrderImg(room.getRoomImgs()), room.getId(), hotelId) : null)
				.build();
	}
	private ImageOrderDto toImageOrderVo(RoomDto room, boolean hasValue) {
		
		return ImageOrderDto.builder()
				.hasImg(hasValue)
				.orders(hasValue ? room.getRoomImgs().stream()
						.map(img -> img.getImageOrder())
						.collect(Collectors.toList()) : new ArrayList<>())
				.value(hasValue ? leastOrderImg(room.getRoomImgs()).getImageOrder() : 0)
				.build();
	}
	
	private List<RoomImgDto> toRoomImgVos(List<springboot.bean.dto.model.RoomImgDto> roomImgs, int roomId, int hotelId) {
		
		return roomImgs.stream().map(roomImg -> toRoomImgVo(roomImg, roomId, hotelId)).collect(Collectors.toList());
	}
	private RoomImgDto toRoomImgVo(springboot.bean.dto.model.RoomImgDto roomImg, int roomId, int hotelId) {
		
		return RoomImgDto.builder()
				.id(roomImg.getId())
				.imgName(roomImg.getImageName())
				.url(ImageUtil.getImgUrl(hotelId, roomId, roomImg.getImageName()))
				.order(roomImg.getImageOrder())
				.build();
	}
	private springboot.bean.dto.model.RoomImgDto leastOrderImg(List<springboot.bean.dto.model.RoomImgDto> imgs){
		
		return imgs.stream()
				.reduce((img1, img2) -> img1.getImageOrder()<img2.getImageOrder() ? img1 : img2)
				.orElse(null);
	}
}
