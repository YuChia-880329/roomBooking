package springboot.trans.fr.home.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.vo.turnPage.TurnPageRespDto;
import springboot.bean.vo.fr.home.HotelRoom;
import springboot.bean.vo.fr.home.turnPage.TurnPageResp;
import springboot.trans.fr.home.vo.HotelRoomTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.home.vo.turnPage.TurnPageRespTrans")
public class TurnPageRespTrans implements VoWoTrans<TurnPageResp, TurnPageRespDto> {

	@Autowired
	@Qualifier("fr.home.vo.HotelRoomTrans")
	private HotelRoomTrans hotelRoomTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public TurnPageResp dtoToVoImpl(TurnPageRespDto dto) {
		
		return TurnPageResp.builder()
				.hotels(hotelRoomTrans.dtoListToVoArray(dto.getHotels(), size -> new HotelRoom[size]))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
