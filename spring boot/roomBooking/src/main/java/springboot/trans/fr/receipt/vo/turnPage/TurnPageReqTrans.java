package springboot.trans.fr.receipt.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.turnPage.TurnPageReqDto;
import springboot.bean.vo.fr.receipt.turnPage.TurnPageReq;
import springboot.checker.fr.receipt.vo.turnPage.TurnPageReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.receipt.vo.turnPage.TurnPageReqTrans")
public class TurnPageReqTrans extends VoRiTransChecked<TurnPageReq, TurnPageReqDto, TurnPageReqChecker> {

	@Override
	public TurnPageReqDto voToDtoImpl(TurnPageReq vo) {
		
		return TurnPageReqDto.builder()
				.page(Integer.parseInt(vo.getPage()))
				.receiptId(Integer.parseInt(vo.getReceiptId()))
				.build();
	}

	@Autowired
	@Qualifier("fr.receipt.vo.turnPage.TurnPageReqChecker")
	@Override
	public void setChecker(TurnPageReqChecker checker) {
		
		this.checker = checker;
	}
}
