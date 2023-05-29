package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.OutputDto;
import springboot.bean.dto.bk.roomList.obj.repo.tablePages.TablePageDto;
import springboot.bean.dto.bk.roomList.vo.changeOrder.ChangeOrderReqDto;
import springboot.bean.dto.bk.roomList.vo.changeOrder.ChangeOrderRespDto;
import springboot.dao.bk.roomList.memory.repo.TablePagesRepoDAO;
import springboot.service.PaginationService;

@Service("bk.roomList.ChangeOrderService")
public class ChangeOrderService {

	@Autowired
	@Qualifier("bk.roomList.memory.repo.TablePagesRepoDAO")
	private TablePagesRepoDAO roomTableRowsRepoDAO;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	@Autowired
	@Qualifier("bk.roomList.RepoService")
	private RepoService repoService;
	
	public ChangeOrderRespDto changeOrder(ChangeOrderReqDto changeOrderReq) {
		
		InputDto input = roomTableRowsRepoDAO.getLastInput();
		input.getSearchParam().setRoomTableOrder(changeOrderReq.getOrder());
		OutputDto output = roomTableRowsRepoDAO.getObj(input);
		TablePageDto tablePageDto = output.getTablePage();
		
		return ChangeOrderRespDto.builder()
				.table(repoService.toTableVo(tablePageDto.getTable()))
				.pagination(paginationService.getPagination(tablePageDto.getCurrentPage(), SearchTableService.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}
