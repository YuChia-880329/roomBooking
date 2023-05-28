package springboot.trans.bk.roomList.vo.searchTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.searchTable.SearchTableRespDto;
import springboot.bean.vo.bk.roomList.searchTable.SearchTableResp;
import springboot.trans.vo.PaginationTrans;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomList.vo.searchTable.SearchTableRespTrans")
public class SearchTableRespTrans implements VoWoTrans<SearchTableResp, SearchTableRespDto> {

	@Autowired
	@Qualifier("bk.roomList.vo.searchTable.TableTrans")
	private TableTrans tableTrans;
	@Autowired
	@Qualifier("vo.PaginationTrans")
	private PaginationTrans paginationTrans;
	
	@Override
	public SearchTableResp dtoToVoImpl(SearchTableRespDto dto) {
		
		return SearchTableResp.builder()
				.table(tableTrans.dtoToVo(dto.getTable()))
				.pagination(paginationTrans.dtoToVo(dto.getPagination()))
				.build();
	}

}
