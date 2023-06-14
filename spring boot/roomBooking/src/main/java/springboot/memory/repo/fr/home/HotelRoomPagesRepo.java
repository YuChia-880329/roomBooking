package springboot.memory.repo.fr.home;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoom;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomList;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomPage;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomPages;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Input;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Output;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.SearchParam;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.exception.IllegalPageException;
import springboot.memory.repo.Repo;
import springboot.service.fr.home.memory.repo.hotelRoomPages.SearchParamService;
import util.LogsUtil;
import util.PageUtil;

@Component("fr.home.HotelRoomPagesRepo")
@SessionScope
public class HotelRoomPagesRepo extends Repo<Input, HotelRoomPages, Output> {

	public static final int ROWS_PER_PAGE = 5;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	@Autowired
	@Qualifier("fr.home.memory.repo.hotelRoomPages.SearchParamService")
	private SearchParamService searchParamService;
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	
	
	private boolean needUpdate;
	private Logger log = LogsUtil.getLogger(HotelRoomPagesRepo.class);
	
	
	public HotelRoomPagesRepo() {
		
		this.needUpdate = false;
	}
	
	public void needUpdate() {
		
		this.needUpdate = true;
	}

	@Override
	protected Input initialInput() {
		
		SearchParam searchParam = SearchParam.builder()
				.page(-1)
				.checkinDate(null)
				.checkoutDate(null)
				.num(null)
				.sectionCode(null)
				.build();
		return Input.builder()
				.searchParam(searchParam)
				.build();
	}

	@Override
	protected boolean isNeedUpdate(Input input) {
		
		return needUpdate ||
				!searchParamService.equals(input.getSearchParam(), lastInput.getSearchParam()) || 
				storeObj.getHotelRoomPageMap().get(input.getSearchParam().getPage()) == null;
	}

	@Override
	protected HotelRoomPages update(Input input) {
		
		SearchParam searchParam = input.getSearchParam();
		int page = searchParam.getPage();
		
		if(page == -1)
			return getDefault();
		
		long totalRows = roomDaoInner.queryFrHotelRoomPagesCount(searchParam.getCheckinDate(), 
				searchParam.getCheckoutDate(), searchParam.getNum(), searchParam.getSectionCode());
		
		if(totalRows > Integer.MAX_VALUE) {
			
			log.warn("資料庫資料過多");
			totalRows = Integer.MAX_VALUE;
		}
		
		int maxPage = PageUtil.countMaxPage(ROWS_PER_PAGE, (int)totalRows);
		int[] pageBounds = PageUtil.countPage(page, PAGES_PER_PAGE_GROUP, maxPage);
		
		if(pageBounds == null)
			throw new IllegalPageException(IllegalPageException.MSG);
		
		Map<Integer, HotelRoomPage> hotelRoomPageMap = new HashMap<>();
		for(int p=pageBounds[0]; p<= pageBounds[1]; p++) {
			
			int[] rowBounds = PageUtil.countRow(ROWS_PER_PAGE, p);
			
			
			List<RoomDto> rooms = roomDaoInner.queryFrHotelRoomPages(searchParam.getCheckinDate(), 
					searchParam.getCheckoutDate(), searchParam.getNum(), searchParam.getSectionCode(), 
					rowBounds[0]-1, ROWS_PER_PAGE);
			
			hotelRoomPageMap.put(p, toHotelRoomPage(rooms, p, searchParam.getCheckinDate(), searchParam.getCheckoutDate()));
		}
		
		if(needUpdate)
			needUpdate = false;
		
		return HotelRoomPages.builder()
				.maxPage(maxPage)
				.hotelRoomPageMap(hotelRoomPageMap)
				.build();
	}

	@Override
	protected Output getOutput(Input input) {
		
		return Output.builder()
				.maxPage(storeObj.getMaxPage())
				.hotelRoomPage(storeObj.getHotelRoomPageMap().get(input.getSearchParam().getPage()))
				.build();
	}
	
	
	private HotelRoomPage toHotelRoomPage(List<RoomDto> rooms, int page, LocalDate checkinDate, LocalDate checkoutDate) {
		
		return HotelRoomPage.builder()
				.hotelRoomList(toHotelRoomList(rooms, checkinDate, checkoutDate))
				.page(page)
				.build();
	}
	private HotelRoomList toHotelRoomList(List<RoomDto> rooms, LocalDate checkinDate, LocalDate checkoutDate) {
		
		return HotelRoomList.builder()
				.hotelRooms(toHotelRooms(rooms, checkinDate, checkoutDate))
				.build();
	}
	private List<HotelRoom> toHotelRooms(List<RoomDto> rooms, LocalDate checkinDate, LocalDate checkoutDate){
		
		return rooms.stream()
				.map(room -> toHotelRoom(room, checkinDate, checkoutDate))
				.collect(Collectors.toList());
	}
	private HotelRoom toHotelRoom(RoomDto room, LocalDate checkinDate, LocalDate checkoutDate){
		
		return HotelRoom.builder()
				.imgName(room.getHotel().getImgName())
				.hotelId(room.getHotelId())
				.hotelName(room.getHotel().getName())
				.sectionName(room.getHotel().getSection().getName())
				.roomId(room.getId())
				.roomName(room.getName())
				.validNum(room.getTotalNum()-room.getInvalidNum()-(int)toUsedNum(room.getBookingOrders(), checkinDate, checkoutDate))
				.price(room.getPrice())
				.build();
	}
	
	private long toUsedNum(List<BookingOrderDto> bookingOrders, LocalDate checkinDate, LocalDate checkoutDate) {
		
		return bookingOrders.stream()
				.filter(bookingOrder -> {
			
					return !(!bookingOrder.getCheckoutDate().isAfter(checkinDate) || 
							!bookingOrder.getCheckinDate().isBefore(checkoutDate));
				}).collect(Collectors.counting());
	}
	
	private HotelRoomPages getDefault() {
		
		Map<Integer, HotelRoomPage> hotelRoomPageMap = new HashMap<>();
		
		hotelRoomPageMap.put(1, HotelRoomPage.builder()
				.hotelRoomList(HotelRoomList.builder()
						.hotelRooms(new ArrayList<>())
						.build())
				.page(1)
				.build());
		return HotelRoomPages.builder()
				.maxPage(1)
				.hotelRoomPageMap(hotelRoomPageMap)
				.build();
	}
}
