package springboot.memory.repo.bk.roomList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.RoomTableRowDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.Input;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.RoomTableRow;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.RoomTableRows;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.SearchParam;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.memory.repo.Repo;
import springboot.service.bk.roomList.memory.repo.roomTableRow.SearchParamService;
import springboot.trans.bk.roomList.obj.repo.roomTableRows.RoomTableRowTrans;
import util.PageUtil;

@Component
@SessionScope
public class RoomTableRowsRepo extends Repo<Input, RoomTableRows> {
	
	public static final int ROWS_PER_PAGE = 10;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	@Autowired
	private SearchParamService searchParamService;
	@Autowired
	private RoomDaoInner roomDaoInner;
	@Autowired
	private RoomTableRowTrans roomTableRowTrans;
	@Autowired
	private LoginStatusDao loginStatusDao;
	
	
	private boolean needUpdate;
	
	
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
				obj.getRoomTableRowMap().get(input.getSearchParam().getPage()) == null;
	}

	@Override
	protected RoomTableRows update(Input input) {
		
		int hotelId = loginStatusDao.getStatus().getHotelId();
		SearchParam searchParam = input.getSearchParam();
		RoomTableOrder roomTableOrder = searchParam.getRoomTableOrder();
		int page = searchParam.getPage();
		
		int[] rowBorders = PageUtil.countRow(ROWS_PER_PAGE, page);
		List<RoomDto> rooms = 
				roomDaoInner.queryBkRoomListRoomTableRows(hotelId, searchParamService.nameQueryStr(searchParam), 
						searchParamService.totalNumMinQueryStr(searchParam), searchParamService.totalNumMaxQueryStr(searchParam), 
						searchParamService.usedNumMinQueryStr(searchParam), searchParamService.usedNumMaxQueryStr(searchParam), 
						searchParamService.invalidNumMinQueryStr(searchParam), searchParamService.invalidNumMaxQueryStr(searchParam), 
						searchParamService.priceMinQueryStr(searchParam), searchParamService.priceMaxQueryStr(searchParam), 
						roomTableOrder.getColName(), roomTableOrder.getDirection(), 
						rowBorders[0], rowBorders[1]);
		
		Map<Integer, List<RoomTableRow>> roomTableRowMap = new HashMap<>();
		roomTableRowMap.put(page, rooms.stream()
				.map(room -> roomTableRowTrans.dtoToObj(toRoomTableRows(room)))
				.collect(Collectors.toList()));
		
		return RoomTableRows.builder()
				.roomTableRowMap(roomTableRowMap)
				.build();
	}
	
	private RoomTableRowDto toRoomTableRows(RoomDto room) {
		
		return RoomTableRowDto.builder()
				.name(room.getName())
				.totalNum(room.getTotalNum())
				.usedNum(room.getUsedNum())
				.invalidNum(room.getInvalidNum())
				.price(room.getPrice())
				.build();
	}
}
