package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.OutputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.TablePageDto;
import springboot.bean.dto.bk.roomList.vo.turnPage.TurnPageReqDto;
import springboot.bean.dto.bk.roomList.vo.turnPage.TurnPageRespDto;
import springboot.dao.bk.roomList.memory.repo.TablePagesRepoDao;
import springboot.memory.repo.bk.roomList.TablePagesRepo;
import springboot.service.PaginationService;

@Service("bk.roomList.TurnPageService")
public class TurnPageService {

	@Autowired
	@Qualifier("bk.roomList.memory.repo.TablePagesRepoDao")
	private TablePagesRepoDao roomTableRowsRepoDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	@Autowired
	@Qualifier("bk.roomList.RepoService")
	private RepoService repoService;
	
	public TurnPageRespDto turnPage(TurnPageReqDto turnPageReq) {
		
		InputDto input = roomTableRowsRepoDao.getLastInput();
		input.getSearchParam().setPage(turnPageReq.getPage());
		OutputDto output = roomTableRowsRepoDao.getObj(input);
		TablePageDto tablePageDto = output.getTablePage();
		
		return TurnPageRespDto.builder()
				.table(repoService.toTableVo(tablePageDto.getTable()))
				.pagination(paginationService.getPagination(tablePageDto.getCurrentPage(), TablePagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}
