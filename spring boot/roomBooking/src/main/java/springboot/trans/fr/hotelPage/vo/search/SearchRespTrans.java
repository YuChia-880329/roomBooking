package springboot.trans.fr.hotelPage.vo.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.search.SearchRespDto;
import springboot.bean.vo.fr.hotelPage.Room;
import springboot.bean.vo.fr.hotelPage.search.SearchResp;
import springboot.trans.fr.hotelPage.vo.RoomTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.SearchRespTrans")
public class SearchRespTrans implements VoWoTrans<SearchResp, SearchRespDto> {

	@Autowired
	@Qualifier("fr.hotelPage.vo.search.RoomTrans")
	private RoomTrans roomTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public SearchResp dtoToVoImpl(SearchRespDto dto) {
		
		return SearchResp.builder()
				.rooms(roomTrans.dtoListToVoArray(dto.getRooms(), size -> new Room[size]))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
