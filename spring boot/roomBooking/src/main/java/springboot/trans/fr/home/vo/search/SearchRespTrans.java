package springboot.trans.fr.home.vo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.vo.search.SearchRespDto;
import springboot.bean.vo.fr.home.search.HotelRoom;
import springboot.bean.vo.fr.home.search.SearchResp;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.home.vo.search.SearchRespTrans")
public class SearchRespTrans implements VoWoTrans<SearchResp, SearchRespDto> {

	@Autowired
	@Qualifier("fr.home.vo.search.HotelRoomTrans")
	private HotelRoomTrans hotelRoomTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public SearchResp dtoToVoImpl(SearchRespDto dto) {
		
		return SearchResp.builder()
				.hotels(hotelRoomTrans.dtoListToVoArray(dto.getHotels(), size -> new HotelRoom[size]))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
