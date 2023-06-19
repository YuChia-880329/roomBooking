package springboot.memory.repo.fr.hotelPage;

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
import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.dto.model.ShowerDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.BedNum;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.DoubleBedNum;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Features;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Image;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Input;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Output;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Room;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.RoomList;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.RoomPage;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.RoomPages;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.SearchParam;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Shower;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.SingleBedNum;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.exception.IllegalPageException;
import springboot.memory.repo.Repo;
import springboot.service.fr.hotelPage.memory.repo.roomPages.SearchParamService;
import util.LogsUtil;
import util.PageUtil;

@Component("fr.hotelPage.RoomPagesRepo")
@SessionScope
public class RoomPagesRepo extends Repo<Input, RoomPages, Output> {

	public static final int ROWS_PER_PAGE = 3;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	@Autowired
	@Qualifier("fr.hotelPage.memory.repo.roomPages.SearchParamService")
	private SearchParamService searchParamService;
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	
	
	private boolean needUpdate;
	private Logger log = LogsUtil.getLogger(RoomPagesRepo.class);
	
	
	public RoomPagesRepo() {
		
		this.needUpdate = false;
	}
	
	public void needUpdate() {
		
		this.needUpdate = true;
	}

	@Override
	protected Input initialInput() {
		
		return Input.builder()
				.searchParam(SearchParam.builder().build())
				.build();
	}

	@Override
	protected boolean isNeedUpdate(Input input) {
		
		return needUpdate ||
				!searchParamService.equals(input.getSearchParam(), lastInput.getSearchParam()) || 
				storeObj.getRoomPageMap().get(input.getSearchParam().getPage()) == null;
	}

	@Override
	protected RoomPages update(Input input) {
		
		SearchParam searchParam = input.getSearchParam();
		if(needDefault(searchParam))
			return getDefault();
		
		
		int page = searchParam.getPage();
		long totalRows = roomDaoInner.queryFrRoomPagesCount(searchParam.getHotelId(), searchParam.getCheckinDate(), 
				searchParam.getCheckoutDate(), searchParam.getNum());
		
		if(totalRows > Integer.MAX_VALUE) {
			
			log.warn("資料庫資料過多");
			totalRows = Integer.MAX_VALUE;
		}
		
		int maxPage = PageUtil.countMaxPage(ROWS_PER_PAGE, (int)totalRows);
		int[] pageBounds = PageUtil.countPage(page, PAGES_PER_PAGE_GROUP, maxPage);
		
		if(pageBounds == null)
			throw new IllegalPageException(IllegalPageException.MSG);
		
		Map<Integer, RoomPage> roomPageMap = new HashMap<>();
		for(int p=pageBounds[0]; p<= pageBounds[1]; p++) {
			
			int[] rowBounds = PageUtil.countRow(ROWS_PER_PAGE, p);
			
			
			List<RoomDto> rooms = roomDaoInner.queryFrRoomPages(searchParam.getHotelId(), searchParam.getCheckinDate(), 
					searchParam.getCheckoutDate(), searchParam.getNum(), rowBounds[0]-1, ROWS_PER_PAGE);
			
			roomPageMap.put(p, toRoomPage(rooms, p, searchParam.getCheckinDate(), searchParam.getCheckoutDate()));
		}
		
		if(needUpdate)
			needUpdate = false;
		
		return RoomPages.builder()
				.maxPage(maxPage)
				.roomPageMap(roomPageMap)
				.build();
	}

	@Override
	protected Output getOutput(Input input) {
		
		return Output.builder()
				.maxPage(storeObj.getMaxPage())
				.roomPage(storeObj.getRoomPageMap().get(input.getSearchParam().getPage()))
				.build();
	}
	
	
	private RoomPage toRoomPage(List<RoomDto> rooms, int page, LocalDate checkinDate, LocalDate checkoutDate) {
		
		return RoomPage.builder()
				.roomList(toRoomList(rooms, checkinDate, checkoutDate))
				.page(page)
				.build();
	}
	private RoomList toRoomList(List<RoomDto> rooms, LocalDate checkinDate, LocalDate checkoutDate) {
		
		return RoomList.builder()
				.rooms(toRooms(rooms, checkinDate, checkoutDate))
				.build();
	}
	private List<Room> toRooms(List<RoomDto> rooms, LocalDate checkinDate, LocalDate checkoutDate){
		
		return rooms.stream()
				.map(room -> toRoom(room, checkinDate, checkoutDate))
				.collect(Collectors.toList());
	}
	private Room toRoom(RoomDto room, LocalDate checkinDate, LocalDate checkoutDate){
		
		return Room.builder()
				.roomId(room.getId())
				.name(room.getName())
				.validNum(room.getTotalNum()-room.getInvalidNum()-toUsedNum(room.getBookingOrders(), checkinDate, checkoutDate))
				.price(room.getPrice())
				.features(toFeatures(room))
				.images(toImages(room.getRoomImgs()))
				.build();
	}
	
	private int toUsedNum(List<BookingOrderDto> bookingOrders, LocalDate checkinDate, LocalDate checkoutDate) {
		
		return bookingOrders.stream()
				.filter(bookingOrder -> {
			
					return !(!bookingOrder.getCheckoutDate().isAfter(checkinDate) || 
							!bookingOrder.getCheckinDate().isBefore(checkoutDate));
				})
				.map(bookingOrder -> bookingOrder.getRoomNum())
				.collect(Collectors.summingInt(n -> n));
	}
	private Features toFeatures(RoomDto room) {
		
		return Features.builder()
				.bedNum(toBedNum(room))
				.area(room.getArea())
				.sceneName(room.getScene().getName())
				.showers(toShowers(room.getShowers()))
				.build();
	}
	private List<Image> toImages(List<RoomImgDto> roomImgs){
		
		return roomImgs.stream()
				.map(roomImg -> toImage(roomImg))
				.collect(Collectors.toList());
	}
	private Image toImage(RoomImgDto roomImg) {
		
		return Image.builder()
				.id(roomImg.getId())
				.imgName(roomImg.getImageName())
				.build();
	}
	private BedNum toBedNum(RoomDto room) {
		
		return BedNum.builder()
				.singleBedNum(toSingleBedNum(room))
				.doubleBedNum(toDoubleBedNum(room))
				.build();
	}
	private SingleBedNum toSingleBedNum(RoomDto room) {
		
		return SingleBedNum.builder()
				.show(room.getSingleBedNum() > 0)
				.num(room.getSingleBedNum())
				.build();
	}
	private DoubleBedNum toDoubleBedNum(RoomDto room) {
		
		return DoubleBedNum.builder()
				.show(room.getDoubleBedNum() > 0)
				.num(room.getDoubleBedNum())
				.build();
	}
	private List<Shower> toShowers(List<ShowerDto> showers){
		
		return showers.stream()
				.map(shower -> toShower(shower))
				.collect(Collectors.toList());
	}
	private Shower toShower(ShowerDto shower) {
		
		return Shower.builder()
				.id(shower.getId())
				.name(shower.getName())
				.build();
	}
	
	private boolean needDefault(SearchParam searchParam) {
		
		return searchParam.getPage()<0 ||
				searchParam.getCheckinDate()==null ||
						searchParam.getCheckoutDate()==null;
	}
	
	private RoomPages getDefault() {
		
		Map<Integer, RoomPage> roomPageMap = new HashMap<>();
		
		roomPageMap.put(1, RoomPage.builder()
				.roomList(RoomList.builder()
						.rooms(new ArrayList<>())
						.build())
				.page(1)
				.build());
		return RoomPages.builder()
				.maxPage(1)
				.roomPageMap(roomPageMap)
				.build();
	}
}
