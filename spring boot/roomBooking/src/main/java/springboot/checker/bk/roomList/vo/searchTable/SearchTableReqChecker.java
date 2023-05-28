package springboot.checker.bk.roomList.vo.searchTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.roomList.searchTable.SearchParam;
import springboot.bean.vo.bk.roomList.searchTable.SearchTableReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.roomList.vo.searchTable.SearchTableReqChecker")
public class SearchTableReqChecker implements Checker<SearchTableReq> {

	@Autowired
	@Qualifier("bk.roomList.vo.searchTable.SearchParamChecker")
	private SearchParamChecker searchParamChecker;
	
	@Override
	public void check(SearchTableReq vo) {
		
		checkVo(vo);
		
		checkSearchTable(vo);
	}
	
	private void checkVo(SearchTableReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	private void checkSearchTable(SearchTableReq vo) {
		
		SearchParam searchParam = vo.getSearchParam();
		
		searchParamChecker.check(searchParam);
	}
}
