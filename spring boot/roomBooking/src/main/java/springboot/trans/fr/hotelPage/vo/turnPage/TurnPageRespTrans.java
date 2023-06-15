package springboot.trans.fr.hotelPage.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.turnPage.TurnPageRespDto;
import springboot.bean.vo.fr.hotelPage.Room;
import springboot.bean.vo.fr.hotelPage.turnPage.TurnPageResp;
import springboot.trans.fr.hotelPage.vo.RoomTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.turnPage.TurnPageRespTrans")
public class TurnPageRespTrans implements VoWoTrans<TurnPageResp, TurnPageRespDto> {

	@Autowired
	@Qualifier("fr.hotelPage.vo.search.RoomTrans")
	private RoomTrans roomTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public TurnPageResp dtoToVoImpl(TurnPageRespDto dto) {
		
		return TurnPageResp.builder()
				.rooms(roomTrans.dtoListToVoArray(dto.getRooms(), size -> new Room[size]))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
