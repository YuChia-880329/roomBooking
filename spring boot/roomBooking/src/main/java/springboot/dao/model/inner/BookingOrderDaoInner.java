package springboot.dao.model.inner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.dto.model.BookingOrderDto;
import springboot.dao.model.BookingOrderDao;
import springboot.trans.model.BookingOrderTrans;


@Repository("model.inner.BookingOrderDaoInner")
public class BookingOrderDaoInner {

	@Autowired
	@Qualifier("model.BookingOrderDao")
	private BookingOrderDao dao;
	@Autowired
	@Qualifier("model.BookingOrderTrans")
	private BookingOrderTrans trans;
	
	
	public long queryBkBookingOrderListTablePagesRowNum(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, Integer roomType, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, List<Integer> payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax) {
		
		return dao.queryBkBookingOrderListTablePagesRowNum(hotelId, idMin, idMax, clientName, clientPhone, roomType, 
				roomNumMin, roomNumMax, priceMin, priceMax, payMethods, checkinDateTimeFrom, checkinDateTimeTo, 
				checkoutDateFrom, checkoutDateTo, useDayMin, useDayMax, totalPriceMin, totalPriceMax);
	}
	
	public List<BookingOrderDto> queryBkBookingOrderListTablePages(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, Integer roomType, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, List<Integer> payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax,
			BookingOrderTableOrder bookingOrderTableOrder, int minRow, int maxRow){
		
		return trans.modelListToDtoList(dao.queryBkBookingOrderListTablePages(hotelId, idMin, idMax, clientName, clientPhone, 
				roomType, roomNumMin, roomNumMax, priceMin, priceMax, payMethods, checkinDateTimeFrom, checkinDateTimeTo, 
				checkoutDateFrom, checkoutDateTo, useDayMin, useDayMax, totalPriceMin, totalPriceMax, bookingOrderTableOrder, 
				minRow, maxRow));
	}
}
