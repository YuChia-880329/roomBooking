package springboot.checker.fr.vo.searchHotel;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.searchHotel.SearchHotelReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.vo.searchHotel.SearchHotelReqChecker")
public class SearchHotelReqChecker implements Checker<SearchHotelReq> {

	@Override
	public void check(SearchHotelReq vo) {
		
		checkVo(vo);
		
		checkName(vo);
	}
	
	private void checkVo(SearchHotelReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkName(SearchHotelReq vo) {
	}
}
