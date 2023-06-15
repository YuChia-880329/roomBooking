package springboot.trans.fr.hotelPage.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.turnPage.TurnPageReqDto;
import springboot.bean.vo.fr.hotelPage.turnPage.TurnPageReq;
import springboot.checker.fr.hotelPage.vo.turnPage.TurnPageReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.hotelPage.vo.turnPage.TurnPageReqTrans")
public class TurnPageReqTrans extends VoRiTransChecked<TurnPageReq, TurnPageReqDto, TurnPageReqChecker> {

	@Override
	public TurnPageReqDto voToDtoImpl(TurnPageReq vo) {
		
		return TurnPageReqDto.builder()
				.page(Integer.parseInt(vo.getPage()))
				.build();
	}

	@Autowired
	@Qualifier("fr.hotelPage.vo.turnPage.TurnPageReqChecker")
	@Override
	public void setChecker(TurnPageReqChecker checker) {
		
		this.checker = checker;
	}
}
