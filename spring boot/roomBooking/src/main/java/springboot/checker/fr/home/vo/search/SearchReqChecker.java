package springboot.checker.fr.home.vo.search;

import org.springframework.stereotype.Component;

import exception.check.NonIntegerNumberException;
import exception.check.NonNumberStringException;
import exception.check.NonPositiveNumberException;
import exception.check.NullException;
import springboot.bean.vo.fr.home.search.SearchReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("fr.home.vo.search.SearchReqChecker")
public class SearchReqChecker implements Checker<SearchReq> {

	public static final String COL_NAME_CHECKIN_DATE = "入住日期";
	public static final String COL_NAME_CHECKOUT_DATE = "退房日期";
	public static final String COL_NAME_NUM = "人數";
	public static final String COL_NAME_SECTION_CODE = "地區";
	
	@Override
	public void check(SearchReq vo) {
		
		checkVo(vo);
		
		checkCheckinDate(vo);
		checkCheckoutDate(vo);
		checkNumCode(vo);
		checkSectionCode(vo);
	}

	private void checkVo(SearchReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	
	private void checkCheckinDate(SearchReq vo) {
		
		String checkinDate = vo.getCheckinDate();
		
		try {
			
			CheckUtil.checkString(checkinDate);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr(COL_NAME_CHECKIN_DATE));
		}
	}
	private void checkCheckoutDate(SearchReq vo) {
		
		String checkoutDate = vo.getCheckoutDate();
		
		try {
			
			CheckUtil.checkString(checkoutDate);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr(COL_NAME_CHECKOUT_DATE));
		}
	}
	private void checkNumCode(SearchReq vo) {
		
		String numCode = vo.getNumCode();
		
		try {
			
			CheckUtil.checkStringIsPositiveIntegerNumberString(numCode);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr(COL_NAME_NUM));
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(COL_NAME_NUM));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(COL_NAME_NUM));
		}catch(NonPositiveNumberException ex) {
			
			throw new RiCheckerException(NonPositiveNumberException.getMsgStr(COL_NAME_NUM));
		}
	}
	private void checkSectionCode(SearchReq vo) {
		
		String sectionCode = vo.getSectionCode();
		
		try {
			
			CheckUtil.checkString(sectionCode);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr(COL_NAME_SECTION_CODE));
		}
	}
}
