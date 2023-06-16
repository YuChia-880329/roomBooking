package springboot.trans.fr.shoppingCart.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.turnPage.TurnPageReqDto;
import springboot.bean.vo.fr.shoppingCart.turnPage.TurnPageReq;
import springboot.checker.fr.shoppingCart.vo.turnPage.TurnPageReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.shoppingCart.vo.turnPage.TurnPageReqTrans")
public class TurnPageReqTrans extends VoRiTransChecked<TurnPageReq, TurnPageReqDto, TurnPageReqChecker> {

	@Override
	public TurnPageReqDto voToDtoImpl(TurnPageReq vo) {
		
		return TurnPageReqDto.builder()
				.page(Integer.parseInt(vo.getPage()))
				.build();
	}

	@Autowired
	@Qualifier("fr.shoppingCart.vo.turnPage.TurnPageReqChecker")
	@Override
	public void setChecker(TurnPageReqChecker checker) {
		
		this.checker = checker;
	}
}
