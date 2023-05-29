package springboot.dao.model.inner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import enumeration.PayMethod;
import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.dto.model.BookingOrderDto;
import springboot.dao.model.BookingOrderDao;
import springboot.trans.model.BookingOrderTrans;


@Repository("model.inner.BookingOrderDaoInner")
public class BookingOrderDaoInner {

	@Autowired
	@Qualifier("model.RoomDao")
	private BookingOrderDao dao;
	@Autowired
	@Qualifier("model.RoomTrans")
	private BookingOrderTrans trans;
	
	
	public Long queryBkRoomListRoomTableRowsRowNum(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, String roomName, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, PayMethod[] payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax) {
		
		return dao.queryBkRoomListRoomTableRowsRowNum(hotelId, idMin, idMax, clientName, clientPhone, roomName, 
				roomNumMin, roomNumMax, priceMin, priceMax, payMethods, checkinDateTimeFrom, checkinDateTimeTo, 
				checkoutDateFrom, checkoutDateTo, useDayMin, useDayMax, totalPriceMin, totalPriceMax);
	}
	
	public List<BookingOrderDto> queryBkRoomListRoomTableRows(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, String roomName, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, PayMethod[] payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax,
			BookingOrderTableOrder bookingOrderTableOrder, int startRow, int maxRowNum){
		
		return trans.modelListToDtoList(dao.queryBkRoomListRoomTableRows(hotelId, idMin, idMax, clientName, clientPhone, 
				roomName, roomNumMin, roomNumMax, priceMin, priceMax, payMethods, checkinDateTimeFrom, checkinDateTimeTo, 
				checkoutDateFrom, checkoutDateTo, useDayMin, useDayMax, totalPriceMin, totalPriceMax, bookingOrderTableOrder, 
				startRow, maxRowNum));
	}
}
