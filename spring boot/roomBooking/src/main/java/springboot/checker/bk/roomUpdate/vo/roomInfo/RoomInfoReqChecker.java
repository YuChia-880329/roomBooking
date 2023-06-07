package springboot.checker.bk.roomUpdate.vo.roomInfo;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomInfoReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.roomUpdate.vo.roomInfo.RoomInfoReqChecker")
public class RoomInfoReqChecker implements Checker<RoomInfoReq> {

	@Override
	public void check(RoomInfoReq vo) {
		
		checkVo(vo);
		
		checkRoomId(vo);
	}

	private void checkVo(RoomInfoReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkRoomId(RoomInfoReq vo) {
		
		int roomId = vo.getRoomId();
		
		CheckUtil.checkNumberIsInteger(roomId);
	}
}
