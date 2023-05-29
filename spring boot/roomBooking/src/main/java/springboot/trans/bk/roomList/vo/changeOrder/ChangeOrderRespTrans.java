package springboot.trans.bk.roomList.vo.changeOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.changeOrder.ChangeOrderRespDto;
import springboot.bean.vo.bk.roomList.changeOrder.ChangeOrderResp;
import springboot.trans.bk.roomList.vo.TableTrans;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomList.vo.changeOrder.ChangeOrderRespTrans")
public class ChangeOrderRespTrans implements VoWoTrans<ChangeOrderResp, ChangeOrderRespDto> {

	@Autowired
	@Qualifier("bk.roomList.vo.TableTrans")
	private TableTrans tableTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public ChangeOrderResp dtoToVoImpl(ChangeOrderRespDto dto) {
		
		return ChangeOrderResp.builder()
				.table(tableTrans.dtoToVo(dto.getTable()))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}
}
