package springboot.service.bk.roomCreate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import enumeration.RoomStatus;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.roomCreate.vo.create.CreateReqDto;
import springboot.bean.dto.bk.roomCreate.vo.create.CreateRespDto;
import springboot.bean.dto.bk.roomCreate.vo.create.NewImgDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.dto.model.ShowerDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.bk.roomList.memory.repo.TablePagesRepoDao;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.dao.model.inner.ShowerDaoInner;
import springboot.exception.NotLoginException;
import util.ImageUtil;

@Service("bk.roomCreate.CreateService")
public class CreateService {

	public static final String SUCCESS_MSG = "新增成功";
	public static final String FAILARE_MSG = "新增失敗";
	
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
	@Qualifier("bk.roomList.memory.repo.TablePagesRepoDao")
	private TablePagesRepoDao tablePagesRepoDao;
	
	@Value("${attr.imgDirPath}")
	private String imgDirPath;
	
	@Transactional
	public CreateRespDto create(CreateReqDto createReq) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		RoomDto room = toRoomVo(createReq, login.getHotelId());
		
		
		room = roomDaoInner.add(room);
		
		
		boolean success = true;
		if(room == null) {
			
			success = false;
		}else {
			
			int roomId = room.getId();
			
			room.setRoomImgs(toRoomImgModels(createReq.getNewImgs(), roomId));
			room = roomDaoInner.update(room);
			if(room == null)
				success = false;
			else
				createReq.getNewImgs().stream()
					.forEach(ni -> saveImg(login.getHotelId(), roomId, ni.getImgName(), ni.getFile()));
		}
		
		if(success)
			tablePagesRepoDao.needUpdate();
		
		return CreateRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILARE_MSG)
				.build();
	}
	
	
	private RoomDto toRoomVo(CreateReqDto createReq, int hotelId) {
		
		return RoomDto.builder()
				.id(0)
				.name(createReq.getName())
				.totalNum(createReq.getTotalNum())
				.invalidNum(createReq.getInvalidNum())
				.usedNum(0)
				.price(createReq.getPrice())
				.singleBedNum(createReq.getSingleBedNum())
				.doubleBedNum(createReq.getDoubleBedNum())
				.area(createReq.getArea())
				.sceneId(createReq.getSceneId())
				.hotelId(hotelId)
				.status(RoomStatus.getByCode(createReq.getStatusId()))
				.showers(toShowerModel(createReq.getShowerIds()))
				.roomImgs(new ArrayList<>())
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
	
	private List<springboot.bean.dto.model.RoomImgDto> toRoomImgModels(List<NewImgDto> newImgs, int roomId){
		
		class MyInt {
			int order = 1;
		}
		MyInt mi = new MyInt();
		
		return newImgs.stream()
				.map(ni -> toRoomImgModel(ni, mi.order++, roomId))
				.collect(Collectors.toList());
	}
	
	private springboot.bean.dto.model.RoomImgDto toRoomImgModel(NewImgDto newImg, int order, int roomId){
		
		return springboot.bean.dto.model.RoomImgDto.builder()
				.id(0)
				.imageName(newImg.getImgName())
				.imageOrder(order)
				.roomId(roomId)
				.build();
	}
	
	private void saveImg(int hotelId, int roomId, String imgName, MultipartFile file) {
		
		try {
			
			ImageUtil.saveImg(imgDirPath, hotelId, roomId, imgName, file);
		} catch (IOException ex) {
			
			throw new RuntimeException(ex);
		}
	}
}
