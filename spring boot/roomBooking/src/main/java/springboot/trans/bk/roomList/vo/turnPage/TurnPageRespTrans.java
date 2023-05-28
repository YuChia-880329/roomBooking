package springboot.trans.bk.roomList.vo.turnPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.turnPage.TurnPageRespDto;
import springboot.bean.vo.bk.roomList.turnPage.TurnPageResp;
import springboot.trans.bk.roomList.vo.TableTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomList.vo.turnPage.TurnPageRespTrans")
public class TurnPageRespTrans implements VoWoTrans<TurnPageResp, TurnPageRespDto> {

	@Autowired
	@Qualifier("bk.roomList.vo.TableTrans")
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
