package springboot.checker.fr.hotelPage.vo.search;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.hotelPage.search.SearchReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.hotelPage.vo.search.SearchReqChecker")
public class SearchReqChecker implements Checker<SearchReq> {

	@Override
	public void check(SearchReq vo) {
		
		checkVo(vo);
		
		checkHotelId(vo);
		checkCheckinDate(vo);
		checkCheckoutDate(vo);
		checkNumCode(vo);
	}
	
	private void checkVo(SearchReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	
	private void checkHotelId(SearchReq vo) {
		
		String hotelId = vo.getHotelId();
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(hotelId);
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
}
