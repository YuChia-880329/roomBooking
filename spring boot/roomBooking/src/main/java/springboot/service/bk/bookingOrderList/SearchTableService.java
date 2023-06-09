package springboot.service.bk.bookingOrderList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.InputDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.OutputDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.SearchParamDto;
import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.TablePageDto;
import springboot.bean.dto.bk.bookingOrderList.vo.searchTable.SearchTableReqDto;
import springboot.bean.dto.bk.bookingOrderList.vo.searchTable.SearchTableRespDto;
import springboot.dao.bk.bookingOrderList.memory.repo.TablePagesRepoDao;
import springboot.service.PaginationService;

@Service("bk.bookingOrderList.SearchTableService")
public class SearchTableService {
	
	public static final int ROWS_PER_PAGE = 10;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	@Autowired
	@Qualifier("bk.bookingOrderList.memory.repo.TablePagesRepoDao")
	private TablePagesRepoDao tablePagesRepoDao;
	@Autowired
	@Qualifier("bk.bookingOrderList.RepoService")
	private RepoService repoService;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	public SearchTableRespDto searchTable(SearchTableReqDto searchTableReq) {
		
		
		InputDto input = InputDto.builder()
				.searchParam(toSearchParamObj(searchTableReq))
				.build();
		OutputDto output = tablePagesRepoDao.getObj(input);
		TablePageDto tablePageDto = output.getTablePage();
		
		return SearchTableRespDto.builder()
				.table(repoService.toTableVo(tablePageDto.getTable()))
				.pagination(paginationService.getPagination(tablePageDto.getCurrentPage(), PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
	
	
	public SearchParamDto toSearchParamObj(SearchTableReqDto searchTableReq) {
		
		return SearchParamDto.builder()
				.page(1)
				.idMin(searchTableReq.getIdMin())
				.idMax(searchTableReq.getIdMax())
				.clientName(searchTableReq.getClientName())
				.clientPhone(searchTableReq.getClientPhone())
				.roomType(searchTableReq.getRoomType())
				.roomNumMin(searchTableReq.getRoomNumMin())
				.roomNumMax(searchTableReq.getRoomNumMax())
				.priceMin(searchTableReq.getPriceMin())
				.priceMax(searchTableReq.getPriceMax())
				.payMethodIds(searchTableReq.getPayMethodIds())
				.checkinDateTimeFrom(searchTableReq.getCheckinDateTimeFrom())
				.checkinDateTimeTo(searchTableReq.getCheckinDateTimeTo())
				.checkoutDateFrom(searchTableReq.getCheckoutDateFrom())
				.checkoutDateTo(searchTableReq.getCheckoutDateTo())
				.useDayMin(searchTableReq.getUseDayMin())
				.useDayMax(searchTableReq.getUseDayMax())
				.totalPriceMin(searchTableReq.getTotalPriceMin())
				.totalPriceMax(searchTableReq.getTotalPriceMax())
				.bookingOrderTableOrder(BookingOrderTableOrder.ID_ASC)
				.build();
	}
}
