package springboot.memory.repo.bk.bookingOrderList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.Input;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.Output;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.SearchParam;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.Table;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.TablePage;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.TablePages;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.TableRow;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.BookingOrderDaoInner;
import springboot.exception.IllegalPageException;
import springboot.exception.NotLoginException;
import springboot.memory.repo.Repo;
import springboot.service.bk.bookingOrderList.SearchTableService;
import springboot.service.bk.bookingOrderList.memory.repo.tablePages.SearchParamService;
import util.LogsUtil;
import util.PageUtil;

@Component("bk.bookingOrderList.TablePagesRepo")
@SessionScope
public class TablePagesRepo extends Repo<Input, TablePages, Output> {
	
	@Autowired
	@Qualifier("bk.bookingOrderList.memory.repo.tablePages.SearchParamService")
	private SearchParamService searchParamService;
	@Autowired
	@Qualifier("model.inner.BookingOrderDaoInner")
	private BookingOrderDaoInner bookingOrderDaoInner;
	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	private boolean needUpdate;
	private Logger log = LogsUtil.getLogger(TablePagesRepo.class);
	
	
	public TablePagesRepo() {
		
		this.needUpdate = false;
	}

	@Override
	protected Input initialInput() {
		
		SearchParam searchParam = SearchParam.builder()
				.page(1)
				.idMin(null)
				.idMax(null)
				.clientName(null)
				.clientPhone(null)
				.roomName(null)
				.roomNumMin(null)
				.roomNumMax(null)
				.priceMin(null)
				.priceMax(null)
				.payMethods(null)
				.checkinDateTimeFrom(null)
				.checkinDateTimeTo(null)
				.checkoutDateFrom(null)
				.checkoutDateTo(null)
				.useDayMin(null)
				.useDayMax(null)
				.totalPriceMin(null)
				.totalPriceMax(null)
				.bookingOrderTableOrder(BookingOrderTableOrder.ID_ASC)
				.build();
		
		return Input.builder()
				.searchParam(searchParam)
				.build();
	}

	@Override
	protected boolean isNeedUpdate(Input input) {
		
		return 	needUpdate ||
				!searchParamService.equals(input.getSearchParam(), lastInput.getSearchParam()) || 
				storeObj.getTablePageMap().get(input.getSearchParam().getPage()) == null;
	}

	@Override
	protected TablePages update(Input input) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		int hotelId = login.getHotelId();
		SearchParam searchParam = input.getSearchParam();
		BookingOrderTableOrder bookingOrderTableOrder = searchParam.getBookingOrderTableOrder();
		int page = searchParam.getPage();
		
		long totalRows = bookingOrderDaoInner.queryBkBookingOrderListTablePagesRowNum(hotelId, searchParam.getIdMin(), searchParam.getIdMax(), 
				searchParam.getClientName(), searchParam.getClientPhone(), searchParam.getRoomName(), searchParam.getRoomNumMin(),
				searchParam.getRoomNumMax(), searchParam.getPriceMin(), searchParam.getPriceMax(), searchParam.getPayMethods(),
				searchParam.getCheckinDateTimeFrom(), searchParam.getCheckinDateTimeTo(), searchParam.getCheckoutDateFrom(),
				searchParam.getCheckoutDateTo(), searchParam.getUseDayMin(), searchParam.getUseDayMax(), searchParam.getTotalPriceMin(), 
				searchParam.getTotalPriceMax());
		
		if(totalRows > Integer.MAX_VALUE) {
			
			log.warn("資料庫資料過多");
			totalRows = Integer.MAX_VALUE;
		}
		
		int maxPage = PageUtil.countMaxPage(SearchTableService.ROWS_PER_PAGE, (int)totalRows);
		int[] pageBounds = PageUtil.countPage(page, SearchTableService.PAGES_PER_PAGE_GROUP, maxPage);
		
		if(pageBounds == null)
			throw new IllegalPageException(IllegalPageException.MSG);
		
		Map<Integer, TablePage> tablePageMap = new HashMap<>();
		for(int p=pageBounds[0]; p<= pageBounds[1]; p++) {
			
			int[] rowBounds = PageUtil.countRow(SearchTableService.ROWS_PER_PAGE, p);
			
			
			List<BookingOrderDto> bookingOrders = bookingOrderDaoInner.queryBkBookingOrderListTablePages(hotelId, searchParam.getIdMin(), searchParam.getIdMax(), 
					searchParam.getClientName(), searchParam.getClientPhone(), searchParam.getRoomName(), searchParam.getRoomNumMin(),
					searchParam.getRoomNumMax(), searchParam.getPriceMin(), searchParam.getPriceMax(), searchParam.getPayMethods(),
					searchParam.getCheckinDateTimeFrom(), searchParam.getCheckinDateTimeTo(), searchParam.getCheckoutDateFrom(),
					searchParam.getCheckoutDateTo(), searchParam.getUseDayMin(), searchParam.getUseDayMax(), searchParam.getTotalPriceMin(), 
					searchParam.getTotalPriceMax(), bookingOrderTableOrder, rowBounds[0], rowBounds[1]);
			
			tablePageMap.put(p, toTablePage(bookingOrders, p));
		}
		
		return TablePages.builder()
				.maxPage(maxPage)
				.tablePageMap(tablePageMap)
				.build();
	}
	
	@Override
	protected Output getOutput(Input input) {
		
		return Output.builder()
				.maxPage(storeObj.getMaxPage())
				.tablePage(storeObj.getTablePageMap().get(input.getSearchParam().getPage()))
				.build();
	}
	
	private TablePage toTablePage(List<BookingOrderDto> bookingOrders, int currentPage) {
		
		return TablePage.builder()
				.table(toTable(bookingOrders))
				.currentPage(currentPage)
				.build();
	}
	private Table toTable(List<BookingOrderDto> bookingOrders) {
		
		return Table.builder()
				.tableRows(toTableRows(bookingOrders))
				.build();
	}
	private List<TableRow> toTableRows(List<BookingOrderDto> bookingOrders) {
		
		return bookingOrders.stream()
				.map(bookingOrder -> toTableRows(bookingOrder))
				.collect(Collectors.toList());
	}
	private TableRow toTableRows(BookingOrderDto bookingOrder) {
		
		return TableRow.builder()
				.id(bookingOrder.getId())
				.clientName(bookingOrder.getMember().getName())
				.clientPhone(bookingOrder.getMember().getPhone())
				.roomName(bookingOrder.getRoom().getName())
				.roomNum(bookingOrder.getRoomNum())
				.price(bookingOrder.getRoom().getPrice())
				.payMethod(bookingOrder.getPayMethod().getName())
				.checkinDateTime(bookingOrder.getCheckinDateTime())
				.checkoutDate(bookingOrder.getCheckoutDate())
				.useDay(bookingOrder.getUseDay())
				.totalPrice(bookingOrder.getTotalMoney())
				.build();
	}
	

}
