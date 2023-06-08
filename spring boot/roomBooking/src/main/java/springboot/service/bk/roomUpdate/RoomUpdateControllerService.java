package springboot.service.bk.roomUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomInfoReq;
import springboot.bean.vo.bk.roomUpdate.update.UpdateReq;
import springboot.trans.bk.roomUpdate.vo.allRooms.AllRoomsRespTrans;
import springboot.trans.bk.roomUpdate.vo.allScenes.AllScenesRespTrans;
import springboot.trans.bk.roomUpdate.vo.allShowers.AllShowersRespTrans;
import springboot.trans.bk.roomUpdate.vo.roomInfo.RoomInfoReqTrans;
import springboot.trans.bk.roomUpdate.vo.roomInfo.RoomInfoRespTrans;
import springboot.trans.bk.roomUpdate.vo.update.UpdateReqTrans;
import springboot.trans.bk.roomUpdate.vo.update.UpdateRespTrans;
import util.ResponseUtil;

@Service("bk.roomUpdate.RoomUpdateControllerService")
public class RoomUpdateControllerService {

	@Autowired
	@Qualifier("bk.roomUpdate.AllShowersService")
	private AllShowersService allShowersService;
	@Autowired
	@Qualifier("bk.roomUpdate.AllScenesService")
	private AllScenesService allScenesService;
	@Autowired
	@Qualifier("bk.roomUpdate.AllRoomsService")
	private AllRoomsService allRoomsService;
	@Autowired
	@Qualifier("bk.roomUpdate.RoomInfoService")
	private RoomInfoService roomInfoService;
	@Autowired
	@Qualifier("bk.roomUpdate.UpdateService")
	private UpdateService updateService;
	
	
	@Autowired
	@Qualifier("bk.roomUpdate.vo.allShowers.AllShowersRespTrans")
	private AllShowersRespTrans allShowersRespTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.allScenes.AllScenesRespTrans")
	private AllScenesRespTrans allScenesRespTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.allRooms.AllRoomsRespTrans")
	private AllRoomsRespTrans allRoomsRespTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.RoomInfoReqTrans")
	private RoomInfoReqTrans roomInfoReqTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.RoomInfoRespTrans")
	private RoomInfoRespTrans roomInfoRespTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.UpdateReqTrans")
	private UpdateReqTrans updateReqTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.UpdateRespTrans")
	private UpdateRespTrans updateRespTrans;
	
	
	public Response allShowers() {
		
		return ResponseUtil.response200(
				allShowersRespTrans.dtoToVo(
						allShowersService.allShowers()));
	}
	public Response allScenes() {
		
		return ResponseUtil.response200(
				allScenesRespTrans.dtoToVo(
						allScenesService.allScenes()));
	}
	public Response allRooms() {
		
		return ResponseUtil.response200(
				allRoomsRespTrans.dtoToVo(
						allRoomsService.allRooms()));
	}
	public Response roomInfo(int roomId) {
		
		RoomInfoReq roomInfoReq = RoomInfoReq.builder()
				.roomId(roomId)
				.build();
		return ResponseUtil.response200(
				roomInfoRespTrans.dtoToVo(
						roomInfoService.roomInfo(
								roomInfoReqTrans.voToDto(roomInfoReq))));
	}
	public Response update(UpdateReq updateReq) {
		
		return ResponseUtil.response200(
				updateRespTrans.dtoToVo(
						updateService.update(
								updateReqTrans.voToDto(updateReq))));
	}
}
