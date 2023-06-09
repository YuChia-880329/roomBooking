package springboot.service.bk.roomCreate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.roomCreate.create.CreateReq;
import springboot.trans.bk.roomCreate.vo.allScenes.AllScenesRespTrans;
import springboot.trans.bk.roomCreate.vo.allShowers.AllShowersRespTrans;
import springboot.trans.bk.roomCreate.vo.create.CreateReqTrans;
import springboot.trans.bk.roomCreate.vo.create.CreateRespTrans;
import util.ResponseUtil;

@Service("bk.roomCreate.RoomCreateControllerService")
public class RoomCreateControllerService {

	@Autowired
	@Qualifier("bk.roomCreate.AllShowersService")
	private AllShowersService allShowersService;
	@Autowired
	@Qualifier("bk.roomCreate.AllScenesService")
	private AllScenesService allScenesService;
	@Autowired
	@Qualifier("bk.roomCreate.CreateService")
	private CreateService createService;
	
	
	@Autowired
	@Qualifier("bk.roomCreate.vo.allShowers.AllShowersRespTrans")
	private AllShowersRespTrans allShowersRespTrans;
	@Autowired
	@Qualifier("bk.roomCreate.vo.allScenes.AllScenesRespTrans")
	private AllScenesRespTrans allScenesRespTrans;
	@Autowired
	@Qualifier("bk.roomCreate.vo.create.CreateReqTrans")
	private CreateReqTrans createReqTrans;
	@Autowired
	@Qualifier("bk.roomCreate.vo.create.CreateRespTrans")
	private CreateRespTrans createRespTrans;
	
	
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
	public Response create(CreateReq createReq) {
		
		return ResponseUtil.response200(
				createRespTrans.dtoToVo(
						createService.create(
								createReqTrans.voToDto(createReq))));
	}
}
