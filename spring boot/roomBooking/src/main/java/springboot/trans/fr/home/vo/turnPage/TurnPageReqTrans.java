package springboot.trans.fr.home.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.vo.turnPage.TurnPageReqDto;
import springboot.bean.vo.fr.home.turnPage.TurnPageReq;
import springboot.checker.fr.home.vo.turnPage.TurnPageReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.home.vo.turnPage.TurnPageReqTrans")
public class TurnPageReqTrans extends VoRiTransChecked<TurnPageReq, TurnPageReqDto, TurnPageReqChecker> {

	@Override
	public TurnPageReqDto voToDtoImpl(TurnPageReq vo) {
		
		return TurnPageReqDto.builder()
				.page(Integer.parseInt(vo.getPage()))
				.build();
	}

	@Autowired
	@Qualifier("fr.home.vo.turnPage.TurnPageReqChecker")
	@Override
	public void setChecker(TurnPageReqChecker checker) {
		
		this.checker = checker;
	}
}
