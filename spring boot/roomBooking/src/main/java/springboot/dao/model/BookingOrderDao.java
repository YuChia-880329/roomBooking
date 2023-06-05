package springboot.dao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.model.BookingOrder;
import springboot.bean.model.Member;
import springboot.bean.model.Room;
import util.DateTimeUtil;
import util.StringConcatUtil;

@Repository("model.BookingOrderDao")
public class BookingOrderDao {
	
	public static final String DATE_TIME_SQL_FORMAT = "YYYY/MM/DD HH24:MI";
	public static final String DATE_SQL_FORMAT = "YYYY/MM/DD";
	
	public static final String BOOKING_ORDER_TABLE_SQL_NAME = "BOOKING_ORDER";
	public static final String ROOM_TABLE_SQL_NAME = "ROOM";
	public static final String MEMBER_TABLE_SQL_NAME = "MEMBER";
	public static final String PAY_METHOD_TABLE_SQL_NAME = "PAY_METHOD";
	
	public static final String BOOKING_ORDER_TABLE_SQL_LABEL = "B";
	public static final String ROOM_TABLE_SQL_LABEL = "R";
	public static final String MEMBER_TABLE_SQL_LABEL = "M";
	public static final String PAY_METHOD_TABLE_SQL_LABEL = "P";
	
	public static final String BOOKING_ORDER_ID_SQL_NAME = "ID";
	public static final String BOOKING_ORDER_CLIENT_ID_SQL_NAME = "CLIENT_ID";
	public static final String BOOKING_ORDER_ROOM_ID_SQL_NAME = "ROOM_ID";
	public static final String BOOKING_ORDER_ROOM_NUM_SQL_NAME = "ROOM_NUM";
	public static final String BOOKING_ORDER_PAY_METHOD_ID_SQL_NAME = "PAY_METHOD_ID";
	public static final String BOOKING_ORDER_CHECKIN_DATETIME_SQL_NAME = "CHECKIN_DATETIME";
	public static final String BOOKING_ORDER_CHECKOUT_DATE_SQL_NAME = "CHECKOUT_DATE";
	public static final String BOOKING_ORDER_USE_DAY_SQL_NAME = "USE_DAY";
	public static final String BOOKING_ORDER_TOTAL_MONEY_SQL_NAME = "TOTAL_MONEY";
	
	public static final String ROOM_TABLE_ID_SQL_NAME = "ID";
	public static final String ROOM_TABLE_HOTEL_ID_SQL_NAME = "HOTEL_ID";
	public static final String ROOM_TABLE_NAME_SQL_NAME = "NAME";
	public static final String ROOM_TABLE_PRICE_SQL_NAME = "PRICE";
	
	public static final String MEMBER_TABLE_ID_SQL_NAME = "ID";
	public static final String MEMBER_TABLE_NAME_SQL_NAME = "NAME";
	public static final String MEMBER_TABLE_PHONE_SQL_NAME = "PHONE";
	
	public static final String PAY_METHOD_TABLE_ID_SQL_NAME = "ID";
	public static final String PAY_METHOD_TABLE_NAME_SQL_NAME = "NAME";
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long queryBkBookingOrderListTablePagesRowNum(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, Integer roomType, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, List<Integer> payMethodIds, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax) {
		
		String sqlSelect = String.format("SELECT %s.%s", BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_ID_SQL_NAME);
		String sqlSelectFrom = sqlSelectFrom(sqlSelect, BOOKING_ORDER_TABLE_SQL_LABEL);
		String sqlSelectFromJoin = sqlSelectFromJoin(sqlSelectFrom);
		String sqlSelectFromJoinWhere = sqlSelectFromJoinWhere(sqlSelectFromJoin, hotelId, idMin, idMax, clientName, clientPhone, 
				roomType, roomNumMin, roomNumMax, priceMin, priceMax, payMethodIds, checkinDateTimeFrom, checkinDateTimeTo, 
				checkoutDateFrom, checkoutDateTo, useDayMin, useDayMax, totalPriceMin, totalPriceMax);
		
		String sql = String.format("SELECT COUNT(%s) CT FROM (%s)", BOOKING_ORDER_ID_SQL_NAME, sqlSelectFromJoinWhere);
		Query query = entityManager.createNativeQuery(sql, RowCount.class);
		
		RowCount rowCount = (RowCount)query.getSingleResult();
		
		return rowCount.getCount();
	}
	
	@SuppressWarnings("unchecked")
	public List<BookingOrder> queryBkBookingOrderListTablePages(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, Integer roomType, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, List<Integer> payMethodIds, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax,
			BookingOrderTableOrder bookingOrderTableOrder, int minRow, int maxRow){
		
		String sql = sqlRowWhere(hotelId, idMin, idMax, clientName, clientPhone, roomType, roomNumMin, roomNumMax, 
				priceMin, priceMax, payMethodIds, checkinDateTimeFrom, checkinDateTimeTo, checkoutDateFrom, checkoutDateTo, 
				useDayMin, useDayMax, totalPriceMin, totalPriceMax, bookingOrderTableOrder, minRow, maxRow);
		
		Query query = entityManager.createNativeQuery(sql, BookingOrder.class);
		
		return (List<BookingOrder>)query.getResultList();
	}
	
	private String sqlRowWhere(
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, Integer roomType, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, List<Integer> payMethodIds, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax,
			BookingOrderTableOrder bookingOrderTableOrder, int minRow, int maxRow) {
		
		String sqlSelect = sqlSelect(BOOKING_ORDER_TABLE_SQL_LABEL);
		String sqlSelectFrom = sqlSelectFrom(sqlSelect, BOOKING_ORDER_TABLE_SQL_LABEL, bookingOrderTableOrder);
		String sqlSelectFromJoin = sqlSelectFromJoin(sqlSelectFrom);
		String sqlSelectFromJoinWhere = sqlSelectFromJoinWhere(sqlSelectFromJoin, hotelId, idMin, idMax, clientName, clientPhone, 
				roomType, roomNumMin, roomNumMax, priceMin, priceMax, payMethodIds, checkinDateTimeFrom, checkinDateTimeTo, 
				checkoutDateFrom, checkoutDateTo, useDayMin, useDayMax, totalPriceMin, totalPriceMax);
		String sql = String.format("%s FROM (%s)", sqlSelect(), sqlSelectFromJoinWhere);
	
		return StringConcatUtil.concate(sql, String.format(" WHERE RN>=%d AND RN<=%d", minRow, maxRow));
	}
	
	private String sqlSelectFromJoinWhere(String sqlSelectFromJoin,
			int hotelId, Integer idMin, Integer idMax, String clientName,
			String clientPhone, Integer roomType, Integer roomNumMin, Integer roomNumMax,
			Integer priceMin, Integer priceMax, List<Integer> payMethodIds, LocalDateTime checkinDateTimeFrom, 
			LocalDateTime checkinDateTimeTo, LocalDate checkoutDateFrom, LocalDate checkoutDateTo, 
			Integer useDayMin, Integer useDayMax, Integer totalPriceMin, Integer totalPriceMax) {
		
		return StringConcatUtil.concate(
				sqlSelectFromJoin, " WHERE ",
				String.format("%s.%s=%d", ROOM_TABLE_SQL_LABEL, ROOM_TABLE_HOTEL_ID_SQL_NAME, hotelId),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_ID_SQL_NAME, () -> String.format(">=%d", idMin), idMin),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_ID_SQL_NAME, () -> String.format("<=%d", idMax), idMax),
				ifNotNull(MEMBER_TABLE_SQL_LABEL, MEMBER_TABLE_NAME_SQL_NAME, () -> String.format(" LIKE '%%%s%%'", clientName), clientName),
				ifNotNull(MEMBER_TABLE_SQL_LABEL, MEMBER_TABLE_PHONE_SQL_NAME, () -> String.format(" LIKE '%%%s%%'", clientPhone), clientPhone),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_ROOM_ID_SQL_NAME, () -> String.format("=%d", roomType), roomType),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_ROOM_NUM_SQL_NAME, () -> String.format(">=%d", roomNumMin), roomNumMin),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_ROOM_NUM_SQL_NAME, () -> String.format("<=%d", roomNumMax), roomNumMax),
				ifNotNull(ROOM_TABLE_SQL_LABEL, ROOM_TABLE_PRICE_SQL_NAME, () -> String.format(">=%d", priceMin), priceMin),
				ifNotNull(ROOM_TABLE_SQL_LABEL, ROOM_TABLE_PRICE_SQL_NAME, () -> String.format("<=%d", priceMax), priceMax),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_PAY_METHOD_ID_SQL_NAME, () -> getPayMethodWhere(payMethodIds), payMethodIds),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_CHECKIN_DATETIME_SQL_NAME, 
						() -> String.format(">=TO_DATE('%s', '%s')", DateTimeUtil.toString(checkinDateTimeFrom), DATE_TIME_SQL_FORMAT), checkinDateTimeFrom),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_CHECKIN_DATETIME_SQL_NAME, 
						() -> String.format("<=TO_DATE('%s', '%s')", DateTimeUtil.toString(checkinDateTimeTo), DATE_TIME_SQL_FORMAT), checkinDateTimeTo),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_CHECKOUT_DATE_SQL_NAME, 
						() -> String.format(">=TO_DATE('%s', '%s')", DateTimeUtil.toString(checkoutDateFrom), DATE_SQL_FORMAT), checkoutDateFrom),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_CHECKOUT_DATE_SQL_NAME, 
						() -> String.format("<=TO_DATE('%s', '%s')", DateTimeUtil.toString(checkoutDateTo), DATE_SQL_FORMAT), checkoutDateTo),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_USE_DAY_SQL_NAME, () -> String.format(">=%d", useDayMin), useDayMin),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_USE_DAY_SQL_NAME, () -> String.format("<=%d", useDayMax), useDayMax),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_TOTAL_MONEY_SQL_NAME, () -> String.format(">=%d", totalPriceMin), totalPriceMin),
				ifNotNull(BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_TOTAL_MONEY_SQL_NAME, () -> String.format("<=%d", totalPriceMax), totalPriceMax));
	}

	
	private String sqlSelectFromJoin(String sqlSelectFrom) {
		
		return StringConcatUtil.concate(
				sqlSelectFrom, " ",
				String.format("JOIN %s %s ", ROOM_TABLE_SQL_NAME, ROOM_TABLE_SQL_LABEL),
				String.format("ON %s.%s=%s.%s ", BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_ROOM_ID_SQL_NAME, 
						ROOM_TABLE_SQL_LABEL, ROOM_TABLE_ID_SQL_NAME),
				String.format("JOIN %s %s ", MEMBER_TABLE_SQL_NAME, MEMBER_TABLE_SQL_LABEL),
				String.format("ON %s.%s=%s.%s ", BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_CLIENT_ID_SQL_NAME, 
						MEMBER_TABLE_SQL_LABEL, MEMBER_TABLE_ID_SQL_NAME),
				String.format("JOIN %s %s ", PAY_METHOD_TABLE_SQL_NAME, PAY_METHOD_TABLE_SQL_LABEL),
				String.format("ON %s.%s=%s.%s", BOOKING_ORDER_TABLE_SQL_LABEL, BOOKING_ORDER_PAY_METHOD_ID_SQL_NAME, 
						PAY_METHOD_TABLE_SQL_LABEL, PAY_METHOD_TABLE_ID_SQL_NAME));
	}
	
	private String sqlSelectFrom(String sqlSelect, String label) {
		
		return StringConcatUtil.concate(
				sqlSelect, " ",
				String.format("FROM %s %s", BOOKING_ORDER_TABLE_SQL_NAME, label));
	}
	
	private String sqlSelectFrom(String sqlSelect, String label, BookingOrderTableOrder bookingOrderTableOrder) {
		
		return StringConcatUtil.concate(
				sqlSelect, ", ",
				String.format("ROW_NUMBER()OVER(ORDER BY %s.%s %s) RN ", 
						getLabel(bookingOrderTableOrder.getBelongModel()), bookingOrderTableOrder.getColName(), 
						bookingOrderTableOrder.getDirection().name()),
				String.format("FROM %s %s", BOOKING_ORDER_TABLE_SQL_NAME, label));
	}
	
	private String sqlSelect(String label) {
		
		return StringConcatUtil.concate(
				"SELECT ", 
				colNameWithLabel(label, BOOKING_ORDER_ID_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_CLIENT_ID_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_ROOM_ID_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_ROOM_NUM_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_PAY_METHOD_ID_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_CHECKIN_DATETIME_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_CHECKOUT_DATE_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_USE_DAY_SQL_NAME), ", ",
				colNameWithLabel(label, BOOKING_ORDER_TOTAL_MONEY_SQL_NAME));
	}
	private String sqlSelect() {
		
		return StringConcatUtil.concate(
				"SELECT ", 
				BOOKING_ORDER_ID_SQL_NAME, ", ",
				BOOKING_ORDER_CLIENT_ID_SQL_NAME, ", ",
				BOOKING_ORDER_ROOM_ID_SQL_NAME, ", ",
				BOOKING_ORDER_ROOM_NUM_SQL_NAME, ", ",
				BOOKING_ORDER_PAY_METHOD_ID_SQL_NAME, ", ",
				BOOKING_ORDER_CHECKIN_DATETIME_SQL_NAME, ", ",
				BOOKING_ORDER_CHECKOUT_DATE_SQL_NAME, ", ",
				BOOKING_ORDER_USE_DAY_SQL_NAME, ", ",
				BOOKING_ORDER_TOTAL_MONEY_SQL_NAME);
	}
	
	
	
	private String colNameWithLabel(String label, String colName) {
		
		return StringConcatUtil.concate(label, ".", colName);
	}
	private <T> String ifNotNull(String label, String colName, Supplier<String> conditionSup, T t) {
		
		return t==null ? "" : String.format(" AND %s.%s%s", label, colName, conditionSup.get());
	}
	private String getLabel(Class<?> belongModel) {
		
		if(belongModel == BookingOrder.class)
			return BOOKING_ORDER_TABLE_SQL_LABEL;
		else if(belongModel == Room.class)
			return ROOM_TABLE_SQL_LABEL;
		else if(belongModel == Member.class)
			return MEMBER_TABLE_SQL_LABEL;
		else if(belongModel == springboot.bean.model.PayMethod.class)
			return PAY_METHOD_TABLE_SQL_LABEL;
		else
			return "";
	}
	private String getPayMethodWhere(List<Integer> payMethodIds) {
		
		String ans = " IN (";
		for(int i=0; i<payMethodIds.size(); i++) {
			
			if(i != 0)
				ans = StringConcatUtil.concate(ans, ", ");
			ans = StringConcatUtil.concate(ans, String.valueOf(payMethodIds.get(i)));
		}
		ans = StringConcatUtil.concate(ans, ") ");
		return ans;
	}
	

}

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
class RowCount{
	
	@Id
	@Column(name = "CT")
	private long count;
}
