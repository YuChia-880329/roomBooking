package springboot.trans.fr.receipt.vo.show;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.vo.show.ShowReqDto;
import springboot.bean.vo.fr.receipt.show.ShowReq;
import springboot.checker.fr.receipt.vo.show.ShowReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.receipt.vo.show.ShowReqTrans")
public class ShowReqTrans extends VoRiTransChecked<ShowReq, ShowReqDto, ShowReqChecker> {

	@Override
	public ShowReqDto voToDtoImpl(ShowReq vo) {
		
		return ShowReqDto.builder()
				.receiptId(Integer.parseInt(vo.getReceiptId()))
				.build();
	}

	@Autowired
	@Qualifier("fr.receipt.vo.show.ShowReqChecker")
	@Override
	public void setChecker(ShowReqChecker checker) {
		
		this.checker = checker;
	}
}
