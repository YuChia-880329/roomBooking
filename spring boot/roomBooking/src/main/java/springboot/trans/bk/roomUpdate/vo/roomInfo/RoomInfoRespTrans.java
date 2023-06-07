package springboot.trans.bk.roomUpdate.vo.roomInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomInfoRespDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomInfoResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.roomInfo.RoomInfoRespTrans")
public class RoomInfoRespTrans implements VoWoTrans<RoomInfoResp, RoomInfoRespDto> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.UsedNumTrans")
	private UsedNumTrans usedNumTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.InvalidNumTrans")
	private InvalidNumTrans invalidNumTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.SceneTrans")
	private SceneTrans sceneTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.ShowerTrans")
	private ShowerTrans showerTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.StatusTrans")
	private StatusTrans statusTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.RoomImgsTrans")
	private RoomImgsTrans roomImgsTrans;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.ImageOrderTrans")
	private ImageOrderTrans imageOrderTrans;
	
	@Override
	public RoomInfoResp dtoToVoImpl(RoomInfoRespDto dto) {
		
		return RoomInfoResp.builder()
				.roomName(dto.getRoomName())
				.totalNum(dto.getTotalNum())
				.usedNum(usedNumTrans.dtoToVo(dto.getUsedNum()))
				.invalidNum(invalidNumTrans.dtoToVo(dto.getInvalidNum()))
				.price(dto.getPrice())
				.singleBedNum(dto.getSingleBedNum())
				.doubleBedNum(dto.getDoubleBedNum())
				.area(dto.getArea())
				.scene(sceneTrans.dtoToVo(dto.getScene()))
				.shower(showerTrans.dtoToVo(dto.getShower()))
				.status(statusTrans.dtoToVo(dto.getStatus()))
				.roomImgs(roomImgsTrans.dtoToVo(dto.getRoomImgs()))
				.imageOrder(imageOrderTrans.dtoToVo(dto.getImageOrder()))
				.build();
	}
}
