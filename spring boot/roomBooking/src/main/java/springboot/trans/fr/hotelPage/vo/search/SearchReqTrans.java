package springboot.trans.fr.hotelPage.vo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import enumeration.fr.home.Num;
import springboot.bean.dto.fr.hotelPage.vo.search.SearchReqDto;
import springboot.bean.vo.fr.hotelPage.search.SearchReq;
import springboot.checker.fr.hotelPage.vo.search.SearchReqChecker;
import springboot.trans.VoRiTransChecked;
import util.DateTimeUtil;

@Component("fr.hotelPage.vo.search.SearchReqTrans")
public class SearchReqTrans extends VoRiTransChecked<SearchReq, SearchReqDto, SearchReqChecker> {

	@Override
	public SearchReqDto voToDtoImpl(SearchReq vo) {
		
		return SearchReqDto.builder()
				.hotelId(Integer.parseInt(vo.getHotelId()))
				.checkinDate(DateTimeUtil.toLocalDateFront(vo.getCheckinDate()))
				.checkoutDate(DateTimeUtil.toLocalDateFront(vo.getCheckoutDate()))
				.num(Num.getByCode(Integer.parseInt(vo.getNumCode())))
				.build();
	}

	@Autowired
	@Qualifier("fr.hotelPage.vo.search.SearchReqChecker")
	@Override
	public void setChecker(SearchReqChecker checker) {
		
		this.checker = checker;
	}
}
