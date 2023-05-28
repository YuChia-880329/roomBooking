package springboot.trans.bk.roomList.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.turnPage.TurnPageReqDto;
import springboot.bean.vo.bk.roomList.turnPage.TurnPageReq;
import springboot.checker.bk.roomList.vo.turnPage.TurnPageReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomList.vo.turnPage.TurnPageReqTrans")
public class TurnPageReqTrans extends VoRiTransChecked<TurnPageReq, TurnPageReqDto, TurnPageReqChecker> {

	@Override
	public TurnPageReqDto voToDtoImpl(TurnPageReq vo) {
		
		return TurnPageReqDto.builder()
				.page(Integer.parseInt(vo.getPage()))
				.build();
	}

	@Autowired
	@Qualifier("bk.roomList.vo.turnPage.TurnPageReqChecker")
	@Override
	public void setChecker(TurnPageReqChecker checker) {
		
		this.checker = checker;
	}
}
