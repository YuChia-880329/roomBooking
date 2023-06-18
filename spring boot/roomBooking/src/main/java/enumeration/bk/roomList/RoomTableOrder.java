package enumeration.bk.roomList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import enumeration.OrderDirection;

public enum RoomTableOrder {

	NAME_ASC("NAME", "name", OrderDirection.ASC, 1), NAME_DESC("NAME", "name", OrderDirection.DESC, 2),
	TOTAL_NUM_ASC("TOTAL_NUM", "totalNum", OrderDirection.ASC, 3), TOTAL_NUM_DESC("TOTAL_NUM", "totalNum", OrderDirection.DESC, 4),
	INVALID_NUM_ASC("INVALID_NUM", "invalidNum", OrderDirection.ASC, 5), INVALID_NUM_DESC("INVALID_NUM", "invalidNum", OrderDirection.DESC, 6),
	PRICE_ASC("PRICE", "price", OrderDirection.ASC, 7), PRICE_DESC("PRICE", "price", OrderDirection.DESC, 8),
	STATUS_ASC("STATUS", "status", OrderDirection.ASC, 9), STATUS_DESC("STATUS", "status", OrderDirection.DESC, 10);
	
	private String colName;
	private String attributeName;
	private OrderDirection direction;
	private int code;
	
	private RoomTableOrder(String colName, String attributeName, OrderDirection direction, int code) {
		
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
	
	public static RoomTableOrder getByCode(int code) {
		
		for(RoomTableOrder order : RoomTableOrder.values()) {
			
			if(order.getCode() == code)
				return order;
		}
		return null;
	}
	
	public static String[] getCodeStrsArray() {
		
		List<String> strList = Arrays.stream(RoomTableOrder.values())
				.map(rto -> String.valueOf(rto.getCode()))
				.collect(Collectors.toList());
		
		return strList.toArray(new String[strList.size()]);
	}
}
