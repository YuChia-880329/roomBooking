package springboot.dao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import enumeration.PayMethod;
import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.model.BookingOrder;
import util.StringConcatUtil;

@Repository("model.BookingOrderDao")
public class BookingOrderDao {
	
	public static final String DATE_TIME_SQL_FORMAT = "YYYY/MM/DD HH24:MI";
	public static final String DATE_SQL_FORMAT = "YYYY/MM/DD";
	
	
	
	public static final String TABLE_SQL_NAME = "BOOKING_ORDER";
	public static final String ROOM_TABLE_SQL_NAME = "ROOM";
	
	public static final String ID_SQL_NAME = "ID";
	public static final String CLIENT_ID_SQL_NAME = "CLIENT_ID";
	public static final String ROOM_ID_SQL_NAME = "ROOM_ID";
	public static final String ROOM_NUM_SQL_NAME = "ROOM_NUM";
	public static final String PAY_METHOD_ID_SQL_NAME = "PAY_METHOD_ID";
	public static final String CHECKIN_DATETIME_SQL_NAME = "CHECKIN_DATETIME";
	public static final String CHECKOUT_DATE_SQL_NAME = "CHECKOUT_DATE";
	public static final String USE_DAY_SQL_NAME = "USE_DAY";
	public static final String TOTAL_MONEY_SQL_NAME = "TOTAL_MONEY";
	
	
	
	public static final String ROOM_TABLE_ID_SQL_NAME = "ID";
	public static final String ROOM_TABLE_HOTEL_ID_SQL_NAME = "HOTEL_ID";
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long queryBkBookingOrderListTablePagesRowNum(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, String roomName, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, PayMethod[] payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax) {
		
		String sql = "SELECT COUNT(?) FROM (SELECT ?, ?, ?, ?, ?, ?, ?, ?, ? FROM ?)";
		Query query = entityManager.createNativeQuery(sql, Long.class);
		
		int index = 1;
		query.setParameter(index++, ID_SQL_NAME);
		
		query.setParameter(index++, ID_SQL_NAME);
		query.setParameter(index++, CLIENT_ID_SQL_NAME);
		query.setParameter(index++, ROOM_ID_SQL_NAME);
		query.setParameter(index++, ROOM_NUM_SQL_NAME);
		query.setParameter(index++, PAY_METHOD_ID_SQL_NAME);
		query.setParameter(index++, CHECKIN_DATETIME_SQL_NAME);
		query.setParameter(index++, CHECKOUT_DATE_SQL_NAME);
		query.setParameter(index++, USE_DAY_SQL_NAME);
		query.setParameter(index++, TOTAL_MONEY_SQL_NAME);
		
		query.setParameter(index++, TABLE_SQL_NAME);
		
		return (Long)query.getSingleResult();
	}
	
	public List<BookingOrder> queryBkBookingOrderListTablePages(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, String roomName, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, PayMethod[] payMethods, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax,
			BookingOrderTableOrder bookingOrderTableOrder, int minRow, int maxRow){
		
		String joinSql = "";
		String whereSql = "";
		
		String sql = StringConcatUtil.concate("SELECT ?, ?, ?, ?, ?, ?, ?, ?, ? FROM (SELECT O.?, O.?, O.?, O.?, O.?, O.?, O.?, O.?, O.?, ROW_NUMBER()OVER(ORDER BY ? ?) FROM ? O ", 
				whereSql, " ", joinSql, " )") ;
		Query query = entityManager.createNativeQuery(sql, Long.class);
		
		return null;
	}
	
	private String sqlFirst(int hotelId, Integer idMin, Integer idMax, Integer roomNumMin, Integer roomNumMax, 
			LocalDateTime checkinDateTimeFrom, LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, 
			LocalDate checkoutDateTo, Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax) {
		
		String sql = StringConcatUtil.concate(selectAllBookingOrderCols("O"), " FROM ", TABLE_SQL_NAME, 
				" O JOIN ", ROOM_TABLE_SQL_NAME, " R ON O.", ROOM_ID_SQL_NAME, "=R.", ROOM_TABLE_ID_SQL_NAME, 
				" WHERE R.", ROOM_TABLE_HOTEL_ID_SQL_NAME, "=", String.valueOf(hotelId));
		
		sql = StringConcatUtil.concate(sql, 
				ifNotNull(idMin, ID_SQL_NAME, String.format(">=%d", idMin)),
				ifNotNull(idMax, ID_SQL_NAME, String.format(">=%d", idMax)),
				ifNotNull(roomNumMin, ROOM_NUM_SQL_NAME, String.format(">=%d", roomNumMin)),
				ifNotNull(roomNumMax, ROOM_NUM_SQL_NAME, String.format(">=%d", roomNumMax)),
				ifNotNull(checkinDateTimeFrom, CHECKIN_DATETIME_SQL_NAME, String.format(">=TO_DATE(%s, %s)", checkinDateTimeFrom, )),
				ifNotNull(checkinDateTimeTo, CHECKIN_DATETIME_SQL_NAME, String.format("<=TO_DATE(%s, %s)", checkinDateTimeTo))
				);
	}
	
	
	private String selectAllBookingOrderCols(String tableSymbol) {
		
		return StringConcatUtil.concate(
				"SELECT ", tableSymbol, ".", ID_SQL_NAME, ", ", 
				tableSymbol, ".", CLIENT_ID_SQL_NAME, ", ", 
				tableSymbol, ".", ROOM_ID_SQL_NAME, ", ", 
				tableSymbol, ".", ROOM_NUM_SQL_NAME, ", ", 
				tableSymbol, ".", PAY_METHOD_ID_SQL_NAME, ", ", 
				tableSymbol, ".", CHECKIN_DATETIME_SQL_NAME, ", ", 
				tableSymbol, ".", CHECKOUT_DATE_SQL_NAME, ", ", 
				tableSymbol, ".", USE_DAY_SQL_NAME, ", ", 
				tableSymbol, ".", TOTAL_MONEY_SQL_NAME);
	}
	
	private <T> String ifNotNull(T t, String colName, String condition) {
		
		if(t == null)
			return StringConcatUtil.concate(" AND ", colName, "IS NOT NULL") ;
		else
			return StringConcatUtil.concate(" AND ", colName, condition);
	}
	
	

}
