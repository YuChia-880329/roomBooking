package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.OutputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.TablePageDto;
import springboot.bean.dto.bk.roomList.vo.searchTable.SearchParamDto;
import springboot.bean.dto.bk.roomList.vo.searchTable.SearchTableReqDto;
import springboot.bean.dto.bk.roomList.vo.searchTable.SearchTableRespDto;
import springboot.dao.bk.roomList.memory.repo.RoomTableRowsRepoDAO;
import springboot.service.PaginationService;

@Service("bk.roomList.SearchTableService")
public class SearchTableService {
	
	public static final int ROWS_PER_PAGE = 10;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	
	@Autowired
	@Qualifier("bk.roomList.memory.repo.RoomTableRowsRepoDAO")
	private RoomTableRowsRepoDAO roomTableRowsRepoDAO;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	@Autowired
	@Qualifier("bk.roomList.RepoService")
	private RepoService repoService;
	

	public SearchTableRespDto searchTable(SearchTableReqDto searchTableReq) {
		
		
		InputDto input = InputDto.builder()
				.searchParam(toSearchParamObj(searchTableReq.getSearchParam()))
				.build();
		OutputDto output = roomTableRowsRepoDAO.getObj(input);
		TablePageDto tablePageDto = output.getTablePage();
		
		return SearchTableRespDto.builder()
				.table(repoService.toTableVo(tablePageDto.getTable()))
				.pagination(paginationService.getPagination(tablePageDto.getCurrentPage(), PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
	
	
	public springboot.bean.dto.bk.roomList.obj.repo.tablePages.SearchParamDto toSearchParamObj(SearchParamDto searchParam) {
		
		return springboot.bean.dto.bk.roomList.obj.repo.tablePages.SearchParamDto.builder()
				.page(1)
				.name(searchParam.getName())
				.totalNumMin(searchParam.getTotalNumMin())
				.totalNumMax(searchParam.getTotalNumMax())
				.usedNumMin(searchParam.getUsedNumMin())
				.usedNumMax(searchParam.getUsedNumMax())
				.invalidNumMin(searchParam.getInvalidNumMin())
				.invalidNumMax(searchParam.getInvalidNumMax())
				.priceMin(searchParam.getPriceMin())
				.priceMax(searchParam.getPriceMax())
				.roomTableOrder(RoomTableOrder.NAME_ASC)
				.build();
	}
}
