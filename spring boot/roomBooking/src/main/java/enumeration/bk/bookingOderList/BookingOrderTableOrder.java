package enumeration.bk.bookingOderList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import enumeration.OrderDirection;
import springboot.bean.model.BookingOrder;
import springboot.bean.model.Member;
import springboot.bean.model.PayMethod;
import springboot.bean.model.Room;

public enum BookingOrderTableOrder {

	ID_ASC("ID", BookingOrder.class, "id", OrderDirection.ASC, 1), 
	ID_DESC("ID", BookingOrder.class, "id", OrderDirection.DESC, 2),
	CLIENT_NAME_ASC("NAME", Member.class, "clientName", OrderDirection.ASC, 3), 
	CLIENT_NAME_DESC("NAME", Member.class, "clientName", OrderDirection.DESC, 4),
	CLIENT_PHONE_ASC("PHONE", Member.class, "clientPhone", OrderDirection.ASC, 5), 
	CLIENT_PHONE_DESC("PHONE", Member.class, "clientPhone", OrderDirection.DESC, 6),
	ROOM_NAME_ASC("NAME", Room.class, "roomName", OrderDirection.ASC, 7), 
	ROOM_NAME_DESC("NAME", Room.class, "roomName", OrderDirection.DESC, 8),
	ROOM_NUM_ASC("ROOM_NUM", BookingOrder.class, "roomNum", OrderDirection.ASC, 9), 
	ROOM_NUM_DESC("ROOM_NUM", BookingOrder.class, "roomNum", OrderDirection.DESC, 10),
	PRICE_ASC("PRICE", Room.class, "price", OrderDirection.ASC, 11), 
	PRICE_DESC("PRICE", Room.class, "price", OrderDirection.DESC, 12),
	PAY_METHOD_ASC("NAME", PayMethod.class, "payMethod", OrderDirection.ASC, 13), 
	PAY_METHOD_DESC("NAME", PayMethod.class, "payMethod", OrderDirection.DESC, 14),
	CHECKIN_DATE_ASC("CHECKIN_DATE", BookingOrder.class, "checkinDate", OrderDirection.ASC, 15), 
	CHECKIN_DATE_DESC("CHECKIN_DATE", BookingOrder.class, "checkinDate", OrderDirection.DESC, 16),
	CHECKOUT_DATE_ASC("CHECKOUT_DATE", BookingOrder.class, "checkoutDate", OrderDirection.ASC, 17), 
	CHECKOUT_DATE_DESC("CHECKOUT_DATE", BookingOrder.class, "checkoutDate", OrderDirection.DESC, 18),
	USE_DAY_ASC("USE_DAY", BookingOrder.class, "useDay", OrderDirection.ASC, 19), 
	USE_DAY_DESC("USE_DAY", BookingOrder.class, "useDay", OrderDirection.DESC, 20),
	TOTAL_MONEY_ASC("TOTAL_MONEY", BookingOrder.class, "totalPrice", OrderDirection.ASC, 21), 
	TOTAL_MONEY_DESC("TOTAL_MONEY", BookingOrder.class, "totalPrice", OrderDirection.DESC, 22);
	
	private String colName;
	private Class<?> belongModel;
	private String attributeName;
	private OrderDirection direction;
	private int code;
	
	private BookingOrderTableOrder(String colName, Class<?> belongModel, String attributeName, OrderDirection direction, int code) {
		
		this.colName = colName;
		this.belongModel = belongModel;
		this.attributeName = attributeName;
		this.direction = direction;
		this.code = code;
	}

	public String getColName() {
		return colName;
	}
	public Class<?> getBelongModel() {
		return belongModel;
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
