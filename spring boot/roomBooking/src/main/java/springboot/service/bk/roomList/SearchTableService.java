package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.OutputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.SearchParamDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.TablePageDto;
import springboot.bean.dto.bk.roomList.vo.searchTable.SearchTableReqDto;
import springboot.bean.dto.bk.roomList.vo.searchTable.SearchTableRespDto;
import springboot.dao.bk.roomList.memory.repo.TablePagesRepoDao;
import springboot.memory.repo.bk.roomList.TablePagesRepo;
import springboot.service.PaginationService;

@Service("bk.roomList.SearchTableService")
public class SearchTableService {
	
	@Autowired
	@Qualifier("bk.roomList.memory.repo.TablePagesRepoDao")
	private TablePagesRepoDao roomTableRowsRepoDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	@Autowired
	@Qualifier("bk.roomList.RepoService")
	private RepoService repoService;
	

	public SearchTableRespDto searchTable(SearchTableReqDto searchTableReq) {
		
		
		InputDto input = InputDto.builder()
				.searchParam(toSearchParamObj(searchTableReq))
				.build();
		OutputDto output = roomTableRowsRepoDao.getObj(input);
		TablePageDto tablePageDto = output.getTablePage();
		
		return SearchTableRespDto.builder()
				.table(repoService.toTableVo(tablePageDto.getTable()))
				.pagination(paginationService.getPagination(tablePageDto.getCurrentPage(), TablePagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
	
	
	public SearchParamDto toSearchParamObj(SearchTableReqDto searchTableReq) {
		
		return SearchParamDto.builder()
				.page(1)
				.name(searchTableReq.getName())
				.totalNumMin(searchTableReq.getTotalNumMin())
				.totalNumMax(searchTableReq.getTotalNumMax())
				.invalidNumMin(searchTableReq.getInvalidNumMin())
				.invalidNumMax(searchTableReq.getInvalidNumMax())
				.priceMin(searchTableReq.getPriceMin())
				.priceMax(searchTableReq.getPriceMax())
				.status(searchTableReq.getStatus())
				.roomTableOrder(RoomTableOrder.NAME_ASC)
				.build();
	}
}
