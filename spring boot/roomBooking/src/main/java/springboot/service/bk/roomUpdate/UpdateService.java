package springboot.service.bk.roomUpdate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import enumeration.RoomStatus;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.roomUpdate.vo.update.NewImgDto;
import springboot.bean.dto.bk.roomUpdate.vo.update.RoomImgDto;
import springboot.bean.dto.bk.roomUpdate.vo.update.UpdateReqDto;
import springboot.bean.dto.bk.roomUpdate.vo.update.UpdateRespDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.dto.model.ShowerDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.dao.model.inner.RoomImgDaoInner;
import springboot.dao.model.inner.ShowerDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.roomUpdate.UpdateService")
public class UpdateService {

	public static final String SUCCESS_MSG = "更新成功";
	public static final String FAILARE_MSG = "更新失敗";
	
	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	@Autowired
	@Qualifier("model.inner.ShowerDaoInner")
	private ShowerDaoInner showerDaoInner;
	@Autowired
	@Qualifier("model.inner.RoomImgDaoInner")
	private RoomImgDaoInner roomImgDaoInner;
	
	@Transactional
	public UpdateRespDto update(UpdateReqDto updateReq) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		RoomDto room = RoomDto.builder()
				.id(updateReq.getId())
				.name(updateReq.getName())
				.totalNum(updateReq.getTotalNum())
				.invalidNum(updateReq.getInvalidNum())
				.usedNum(updateReq.getUsedNum())
				.price(updateReq.getPrice())
				.singleBedNum(updateReq.getSingleBedNum())
				.doubleBedNum(updateReq.getDoubleBedNum())
				.area(updateReq.getArea())
				.sceneId(updateReq.getSceneId())
				.hotelId(login.getHotelId())
				.status(RoomStatus.getByCode(updateReq.getStatusId()))
				.showers(toShowerModel(updateReq.getShowerIds()))
				.roomImgs(toRoomImgModels(updateReq.getRoomImgs(), updateReq.getNewImgs(), updateReq.getId()))
				.build();
		room = roomDaoInner.update(room);
		
		boolean success = true;
		if(room == null)
			success = false;
		
		return UpdateRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILARE_MSG)
				.build();
	}
	
	
	private List<ShowerDto> toShowerModel(List<Integer> showerIds) {
		
		return showerIds.stream()
				.map(si -> toShowerModel(si))
				.collect(Collectors.toList());
	}
	private ShowerDto toShowerModel(int showerId) {
		
		return showerDaoInner.findById(showerId).get();
	}
	
	
	private List<springboot.bean.dto.model.RoomImgDto> toRoomImgModels(List<RoomImgDto> roomImgs, 
			List<NewImgDto> newImgs, int roomId){
		
		class MyInt {
			int order = 1;
		}
		MyInt mi = new MyInt();
		List<springboot.bean.dto.model.RoomImgDto> list = roomImgs.stream().map(ri -> toRoomImgModel(ri, mi.order++)).collect(Collectors.toList());
		list.addAll(newImgs.stream()
				.map(ni -> toRoomImgModel(ni, mi.order++, roomId))
				.collect(Collectors.toList()));
		
		return list;
	}
	
	private springboot.bean.dto.model.RoomImgDto toRoomImgModel(RoomImgDto roomImg, int order){
		
		springboot.bean.dto.model.RoomImgDto oldRoomImg = roomImgDaoInner.findById(roomImg.getId()).get();
	
		oldRoomImg.setImageOrder(order);
		return oldRoomImg;
	}
	private springboot.bean.dto.model.RoomImgDto toRoomImgModel(NewImgDto newImg, int order, int roomId){
		
		return springboot.bean.dto.model.RoomImgDto.builder()
				.id(-1)
				.imageName(newImg.getImgName())
				.imageOrder(order)
				.roomId(roomId)
				.build();
	}
}
