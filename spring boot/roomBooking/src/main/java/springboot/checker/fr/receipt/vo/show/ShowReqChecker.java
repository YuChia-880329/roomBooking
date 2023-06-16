package springboot.checker.fr.receipt.vo.show;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.receipt.show.ShowReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.receipt.vo.show.ShowReqChecker")
public class ShowReqChecker implements Checker<ShowReq> {

	@Override
	public void check(ShowReq vo) {
		
		checkVo(vo);
		
		checkReceiptId(vo);
	}
	
	private void checkVo(ShowReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkReceiptId(ShowReq vo) {
		
		String receiptId = vo.getReceiptId();
		
		CheckUtil.checkStringIsNonNegativeIntegerNumberString(receiptId);
	}
}
