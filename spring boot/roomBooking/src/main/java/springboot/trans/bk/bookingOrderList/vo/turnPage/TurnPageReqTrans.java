package springboot.trans.bk.bookingOrderList.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.turnPage.TurnPageReqDto;
import springboot.bean.vo.bk.bookingOrderList.turnPage.TurnPageReq;
import springboot.checker.bk.bookingOrderList.vo.turnPage.TurnPageReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.bookingOrderList.vo.turnPage.TurnPageReqTrans")
public class TurnPageReqTrans extends VoRiTransChecked<TurnPageReq, TurnPageReqDto, TurnPageReqChecker> {

	@Override
	public TurnPageReqDto voToDtoImpl(TurnPageReq vo) {
		
		return TurnPageReqDto.builder()
				.page(Integer.parseInt(vo.getPage()))
				.build();
	}

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.turnPage.TurnPageReqChecker")
	@Override
	public void setChecker(TurnPageReqChecker checker) {
		
		this.checker = checker;
	}
}
