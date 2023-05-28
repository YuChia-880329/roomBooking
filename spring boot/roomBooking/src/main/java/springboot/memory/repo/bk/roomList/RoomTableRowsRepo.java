package springboot.memory.repo.bk.roomList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.obj.bk.roomList.repo.tablePages.Input;
import springboot.bean.obj.bk.roomList.repo.tablePages.Output;
import springboot.bean.obj.bk.roomList.repo.tablePages.TableRow;
import springboot.bean.obj.bk.roomList.repo.tablePages.Table;
import springboot.bean.obj.bk.roomList.repo.tablePages.TablePage;
import springboot.bean.obj.bk.roomList.repo.tablePages.TablePages;
import springboot.bean.obj.bk.roomList.repo.tablePages.SearchParam;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.exception.IllegalPageException;
import springboot.exception.NotLoginException;
import springboot.memory.repo.Repo;
import springboot.service.bk.roomList.SearchTableService;
import springboot.service.bk.roomList.memory.repo.roomTableRow.SearchParamService;
import springboot.trans.bk.roomList.obj.repo.tablePages.TableRowTrans;
import util.LogsUtil;
import util.PageUtil;

@Component("bk.roomList.RoomTableRowsRepo")
@SessionScope
public class RoomTableRowsRepo extends Repo<Input, TablePages, Output> {
	
	@Autowired
	@Qualifier("bk.roomList.memory.repo.roomTableRow.SearchParamService")
	private SearchParamService searchParamService;
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	@Autowired
	@Qualifier("bk.roomList.obj.repo.tablePages.TableRowTrans")
	private TableRowTrans roomTableRowTrans;
	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	private boolean needUpdate;
	private Logger log = LogsUtil.getLogger(RoomTableRowsRepo.class);
	
	
	public RoomTableRowsRepo() {
		
		this.needUpdate = false;
	}

	@Override
	protected Input initialInput() {
		
		SearchParam searchParam = SearchParam.builder()
				.page(1)
				.name(null)
				.totalNumMin(null)
				.totalNumMax(null)
				.usedNumMin(null)
				.usedNumMax(null)
				.invalidNumMin(null)
				.invalidNumMax(null)
				.priceMin(null)
				.priceMax(null)
				.roomTableOrder(RoomTableOrder.NAME_ASC)
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
		RoomTableOrder roomTableOrder = searchParam.getRoomTableOrder();
		int page = searchParam.getPage();
		
		long totalRows = roomDaoInner.queryBkRoomListRoomTableRowsRowNum(hotelId, searchParam.getName(), searchParam.getTotalNumMin(), searchParam.getTotalNumMax(), 
				searchParam.getUsedNumMin(), searchParam.getUsedNumMax(), 
				searchParam.getInvalidNumMin(), searchParam.getInvalidNumMax(), 
				searchParam.getPriceMin(), searchParam.getPriceMax());
		
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
			
			
			List<RoomDto> rooms = roomDaoInner.queryBkRoomListRoomTableRows(hotelId, searchParam.getName(), 
					searchParam.getTotalNumMin(), searchParam.getTotalNumMax(), 
					searchParam.getUsedNumMin(), searchParam.getUsedNumMax(), 
					searchParam.getInvalidNumMin(), searchParam.getInvalidNumMax(), 
					searchParam.getPriceMin(), searchParam.getPriceMax(),
					roomTableOrder, rowBounds[0], SearchTableService.ROWS_PER_PAGE);
			
			tablePageMap.put(p, toTablePage(rooms, p));
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
	
	private TablePage toTablePage(List<RoomDto> rooms, int currentPage) {
		
		return TablePage.builder()
				.table(toTable(rooms))
				.currentPage(currentPage)
				.build();
	}
	private Table toTable(List<RoomDto> rooms) {
		
		return Table.builder()
				.tableRows(toTableRows(rooms))
				.build();
	}
	private List<TableRow> toTableRows(List<RoomDto> rooms) {
		
		return rooms.stream()
				.map(room -> toTableRows(room))
				.collect(Collectors.toList());
	}
	private TableRow toTableRows(RoomDto room) {
		
		return TableRow.builder()
				.name(room.getName())
				.totalNum(room.getTotalNum())
				.usedNum(room.getUsedNum())
				.invalidNum(room.getInvalidNum())
				.price(room.getPrice())
				.build();
	}
	

}
