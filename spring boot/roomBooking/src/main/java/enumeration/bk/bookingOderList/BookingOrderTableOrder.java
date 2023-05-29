package enumeration.bk.bookingOderList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import enumeration.OrderDirection;

public enum BookingOrderTableOrder {

	ID_ASC("ID", "id", OrderDirection.ASC, 1), ID_DESC("ID", "id", OrderDirection.DESC, 2),
	CLIENT_NAME_ASC("", "clientName", OrderDirection.ASC, 3), CLIENT_NAME_DESC("", "clientName", OrderDirection.DESC, 4),
	CLIENT_PHONE_ASC("", "clientPhone", OrderDirection.ASC, 3), CLIENT_PHONE_DESC("", "clientPhone", OrderDirection.DESC, 4),
	ROOM_NAME_ASC("", "roomName", OrderDirection.ASC, 5), ROOM_NAME_DESC("", "roomName", OrderDirection.DESC, 6),
	ROOM_NUM_ASC("ROOM_NUM", "roomNum", OrderDirection.ASC, 7), ROOM_NUM_DESC("ROOM_NUM", "roomNum", OrderDirection.DESC, 8),
	PRICE_ASC("", "price", OrderDirection.ASC, 9), PRICE_DESC("", "price", OrderDirection.DESC, 10),
	PAY_METHOD_ASC("", "payMethod", OrderDirection.ASC, 9), PAY_METHOD_DESC("", "payMethod", OrderDirection.DESC, 10),
	CHECKIN_DATETIME_ASC("CHECKIN_DATETIME", "checkinDateTime", OrderDirection.ASC, 11), CHECKIN_DATETIME_DESC("CHECKIN_DATETIME", "checkinDateTime", OrderDirection.DESC, 12),
	CHECKOUT_DATE_ASC("CHECKOUT_DATE", "checkoutDate", OrderDirection.ASC, 13), CHECKOUT_DATE_DESC("CHECKOUT_DATE", "checkoutDate", OrderDirection.DESC, 14),
	USE_DAY_ASC("USE_DAY", "useDay", OrderDirection.ASC, 15), USE_DAY_DESC("USE_DAY", "useDay", OrderDirection.DESC, 16),
	TOTAL_MONEY_ASC("TOTAL_MONEY", "totalPrice", OrderDirection.ASC, 17), TOTAL_MONEY_DESC("TOTAL_MONEY", "totalPrice", OrderDirection.DESC, 18);
	
	private String colName;
	private String attributeName;
	private OrderDirection direction;
	private int code;
	
	private BookingOrderTableOrder(String colName, String attributeName, OrderDirection direction, int code) {
		
		this.colName = colName;
		this.attributeName = attributeName;
		this.direction = direction;
		this.code = code;
	}

	public String getColName() {
		return colName;
	}
	public String getAttributeName() {
		return attributeName;
	}
	public OrderDirection getDirection() {
		return direction;
	}
	public int getCode() {
		return code;
	}
	
	public static BookingOrderTableOrder getByCode(int code) {
		
		for(BookingOrderTableOrder order : BookingOrderTableOrder.values()) {
			
			if(order.getCode() == code)
				return order;
		}
		return null;
	}
	
	public static String[] getCodeStrsArray() {
		
		List<String> strList = Arrays.stream(BookingOrderTableOrder.values())
				.map(rto -> String.valueOf(rto.getCode()))
				.collect(Collectors.toList());
		
		return strList.toArray(new String[strList.size()]);
	}
}
