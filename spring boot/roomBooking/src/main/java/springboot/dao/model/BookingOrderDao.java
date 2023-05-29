package springboot.dao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import enumeration.PayMethod;
import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.model.BookingOrder;

@Repository("model.BookingOrderDao")
public class BookingOrderDao {
	
	public Long queryBkRoomListRoomTableRowsRowNum(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, String roomName, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, PayMethod[] payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax) {
		
		return null;
	}
	
	public List<BookingOrder> queryBkRoomListRoomTableRows(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, String roomName, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, PayMethod[] payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax,
			BookingOrderTableOrder bookingOrderTableOrder, int startRow, int maxRowNum){
		
		return null;
	}
}
