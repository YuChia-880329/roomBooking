package springboot.service.bk.bookingOrderList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.OutputDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.TablePageDto;
import springboot.bean.dto.bk.bookingOrderList.vo.changeOrder.ChangeOrderReqDto;
import springboot.bean.dto.bk.bookingOrderList.vo.changeOrder.ChangeOrderRespDto;
import springboot.dao.bk.bookingOrderList.memory.repo.TablePagesRepoDao;
import springboot.memory.repo.bk.bookingOrderList.TablePagesRepo;
import springboot.service.PaginationService;

@Service("bk.bookingOrderList.ChangeOrderService")
public class ChangeOrderService {

	@Autowired
	@Qualifier("bk.bookingOrderList.memory.repo.TablePagesRepoDao")
	private TablePagesRepoDao roomTableRowsRepoDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	@Autowired
	@Qualifier("bk.bookingOrderList.RepoService")
	private RepoService repoService;
	
	public ChangeOrderRespDto changeOrder(ChangeOrderReqDto changeOrderReq) {
		
		InputDto input = roomTableRowsRepoDao.getLastInput();
		input.getSearchParam().setBookingOrderTableOrder(changeOrderReq.getOrder());
		OutputDto output = roomTableRowsRepoDao.getObj(input);
		TablePageDto tablePageDto = output.getTablePage();
		
		return ChangeOrderRespDto.builder()
				.table(repoService.toTableVo(tablePageDto.getTable()))
				.pagination(paginationService.getPagination(tablePageDto.getCurrentPage(), TablePagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}
