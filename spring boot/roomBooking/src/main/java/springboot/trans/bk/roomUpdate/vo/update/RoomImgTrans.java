package springboot.trans.bk.roomUpdate.vo.update;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.update.RoomImgDto;
import springboot.bean.vo.bk.roomUpdate.update.RoomImg;
import springboot.checker.bk.roomUpdate.vo.update.RoomImgChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomUpdate.vo.update.RoomImgTrans")
public class RoomImgTrans extends VoRiTransChecked<RoomImg, RoomImgDto, RoomImgChecker> {

	@Override
	public RoomImgDto voToDtoImpl(RoomImg vo) {
		
		return RoomImgDto.builder()
				.id(vo.getId())
				.order(vo.getOrder())
				.build();
	}

	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.RoomImgChecker")
	@Override
	public void setChecker(RoomImgChecker checker) {
		
		this.checker = checker;
	}
}
