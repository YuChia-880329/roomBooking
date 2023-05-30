package springboot.trans.bk.bookingOrderList.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.turnPage.TurnPageRespDto;
import springboot.bean.vo.bk.bookingOrderList.turnPage.TurnPageResp;
import springboot.trans.bk.bookingOrderList.vo.TableTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.bookingOrderList.vo.turnPage.TurnPageRespTrans")
public class TurnPageRespTrans implements VoWoTrans<TurnPageResp, TurnPageRespDto> {

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.TableTrans")
	private TableTrans tableTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public TurnPageResp dtoToVoImpl(TurnPageRespDto dto) {
		
		return TurnPageResp.builder()
				.table(tableTrans.dtoToVo(dto.getTable()))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
