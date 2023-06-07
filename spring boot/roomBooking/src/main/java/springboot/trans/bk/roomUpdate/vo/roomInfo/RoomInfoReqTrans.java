package springboot.trans.bk.roomUpdate.vo.roomInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomInfoReqDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomInfoReq;
import springboot.checker.bk.roomUpdate.vo.roomInfo.RoomInfoReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomUpdate.vo.roomInfo.RoomInfoReqTrans")
public class RoomInfoReqTrans extends VoRiTransChecked<RoomInfoReq, RoomInfoReqDto, RoomInfoReqChecker> {

	@Override
	public RoomInfoReqDto voToDtoImpl(RoomInfoReq vo) {
		
		return RoomInfoReqDto.builder()
				.roomId(vo.getRoomId())
				.build();
	}

	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.RoomInfoReqChecker")
	@Override
	public void setChecker(RoomInfoReqChecker checker) {
		
		this.checker = checker;
	}

}
