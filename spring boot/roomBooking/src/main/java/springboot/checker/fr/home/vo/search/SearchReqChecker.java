package springboot.checker.fr.home.vo.search;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.home.search.SearchReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.home.vo.search.SearchReqChecker")
public class SearchReqChecker implements Checker<SearchReq> {

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
		
		CheckUtil.checkString(checkinDate);
	}
	private void checkCheckoutDate(SearchReq vo) {
		
		String checkoutDate = vo.getCheckoutDate();
		
		CheckUtil.checkString(checkoutDate);
	}
	private void checkNumCode(SearchReq vo) {
		
		String numCode = vo.getNumCode();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(numCode);
	}
	private void checkSectionCode(SearchReq vo) {
		
		String sectionCode = vo.getSectionCode();
		
		CheckUtil.checkString(sectionCode);
	}
}
