package springboot.checker.bk.roomList.vo.turnPage;

import org.springframework.stereotype.Component;

import exception.check.NonIntegerNumberException;
import exception.check.NonNumberStringException;
import exception.check.NonPositiveNumberException;
import springboot.bean.vo.bk.roomList.turnPage.TurnPageReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.roomList.vo.turnPage.TurnPageReqChecker")
public class TurnPageReqChecker implements Checker<TurnPageReq> {

	public static final String PAGE_FIELD_NAME = "頁數";
	
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
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(PAGE_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(PAGE_FIELD_NAME));
		}catch(NonPositiveNumberException ex) {
			
			throw new RiCheckerException(NonPositiveNumberException.getMsgStr(PAGE_FIELD_NAME));
		}
	}

}
