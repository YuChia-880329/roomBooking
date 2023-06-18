package springboot.trans.fr.vo.searchHotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.vo.searchHotel.SearchHotelReqDto;
import springboot.bean.vo.fr.searchHotel.SearchHotelReq;
import springboot.checker.fr.vo.searchHotel.SearchHotelReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.vo.searchHotel.SearchHotelReqTrans")
public class SearchHotelReqTrans extends VoRiTransChecked<SearchHotelReq, SearchHotelReqDto, SearchHotelReqChecker> {

	@Override
	public SearchHotelReqDto voToDtoImpl(SearchHotelReq vo) {
		
		return SearchHotelReqDto.builder()
				.name(vo.getName())
				.build();
	}

	@Autowired
	@Qualifier("fr.vo.searchHotel.SearchHotelReqChecker")
	@Override
	public void setChecker(SearchHotelReqChecker checker) {
		
		this.checker = checker;
	}
}
