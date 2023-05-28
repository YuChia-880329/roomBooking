package springboot.trans.bk.roomList.vo.searchTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.searchTable.SearchTableReqDto;
import springboot.bean.vo.bk.roomList.searchTable.SearchTableReq;
import springboot.checker.bk.roomList.vo.searchTable.SearchTableReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomList.vo.searchTable.SearchTableReqTrans")
public class SearchTableReqTrans extends VoRiTransChecked<SearchTableReq, SearchTableReqDto, SearchTableReqChecker> {

	@Autowired
	@Qualifier("bk.roomList.vo.searchTable.SearchParamTrans")
	private SearchParamTrans searchParamTrans;
	
	@Override
	public SearchTableReqDto voToDtoImpl(SearchTableReq vo) {
		
		return SearchTableReqDto.builder()
				.searchParam(searchParamTrans.voToDto(vo.getSearchParam()))
				.build();
	}

	@Autowired
	@Override
	public void setChecker(SearchTableReqChecker checker) {
		
		this.checker = checker;
	}
}
