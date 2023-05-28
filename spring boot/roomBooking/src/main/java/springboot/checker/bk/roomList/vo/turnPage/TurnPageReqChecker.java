package springboot.checker.bk.roomList.vo.turnPage;

import org.springframework.stereotype.Component;

import exception.check.InvalidInputException;
import springboot.bean.vo.bk.roomList.turnPage.TurnPageReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.CheckerException;
import util.CheckUtil;

@Component("bk.roomList.vo.turnPage.TurnPageReqChecker")
public class TurnPageReqChecker implements Checker<TurnPageReq> {

	@Override
	public void check(TurnPageReq vo) {
		
		checkVo(vo);
		
		checkPage(vo);
	}
	
	private void checkVo(TurnPageReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkPage(TurnPageReq vo) {
		
		String page = vo.getPage();
		
		try {
			
			CheckUtil.checkStringIsPositiveIntegerNumberString(page);
		}catch(InvalidInputException ex) {
			
			throw new CheckerException(ex.getMessage());
		}
	}

}
