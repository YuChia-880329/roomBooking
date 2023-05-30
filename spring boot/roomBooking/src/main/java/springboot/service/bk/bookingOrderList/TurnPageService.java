package springboot.service.bk.bookingOrderList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.OutputDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.TablePageDto;
import springboot.bean.dto.bk.bookingOrderList.vo.turnPage.TurnPageReqDto;
import springboot.bean.dto.bk.bookingOrderList.vo.turnPage.TurnPageRespDto;
import springboot.dao.bk.bookingOrderList.memory.repo.TablePagesRepoDAO;
import springboot.service.PaginationService;

@Service("bk.bookingOrderList.TurnPageService")
public class TurnPageService {

	@Autowired
	@Qualifier("bk.bookingOrderList.memory.repo.TablePagesRepoDAO")
	private TablePagesRepoDAO roomTableRowsRepoDAO;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	@Autowired
	@Qualifier("bk.bookingOrderList.RepoService")
	private RepoService repoService;
	
	public TurnPageRespDto turnPage(TurnPageReqDto turnPageReq) {
		
		InputDto input = roomTableRowsRepoDAO.getLastInput();
		input.getSearchParam().setPage(turnPageReq.getPage());
		OutputDto output = roomTableRowsRepoDAO.getObj(input);
		TablePageDto tablePageDto = output.getTablePage();
		
		return TurnPageRespDto.builder()
				.table(repoService.toTableVo(tablePageDto.getTable()))
				.pagination(paginationService.getPagination(tablePageDto.getCurrentPage(), SearchTableService.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}
