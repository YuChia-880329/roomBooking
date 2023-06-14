package springboot.trans.fr.home.vo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import enumeration.fr.home.Num;
import springboot.bean.dto.fr.home.vo.search.SearchReqDto;
import springboot.bean.vo.fr.home.search.SearchReq;
import springboot.checker.fr.home.vo.search.SearchReqChecker;
import springboot.trans.VoRiTransChecked;
import util.DateTimeUtil;

@Component("fr.home.vo.search.SearchReqTrans")
public class SearchReqTrans extends VoRiTransChecked<SearchReq, SearchReqDto, SearchReqChecker> {

	@Override
	public SearchReqDto voToDtoImpl(SearchReq vo) {
		
		return SearchReqDto.builder()
				.checkinDate(DateTimeUtil.toLocalDateFront(vo.getCheckinDate()))
				.checkoutDate(DateTimeUtil.toLocalDateFront(vo.getCheckoutDate()))
				.num(Num.getByCode(Integer.parseInt(vo.getNumCode())))
				.sectionCode(vo.getSectionCode())
				.build();
	}

	@Autowired
	@Qualifier("fr.home.vo.search.SearchReqChecker")
	@Override
	public void setChecker(SearchReqChecker checker) {
		
		this.checker = checker;
	}
}
