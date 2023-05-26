package enumeration.bk.roomList;

public enum RoomTableOrder {

	NAME_ASC("NAME", "ASC", 1), NAME_DESC("NAME", "DESC", 2),
	TOTAL_NUM_ASC("TOTAL_NUM", "ASC", 3), TOTAL_NUM_DESC("TOTAL_NUM", "DESC", 4),
	USED_NUM_ASC("USED_NUM", "ASC", 5), USED_NUM_DESC("USED_NUM", "DESC", 6),
	INVALID_NUM_ASC("INVALID_NUM", "ASC", 7), INVALID_NUM_DESC("INVALID_NUM", "DESC", 8),
	PRICE_ASC("PRICE", "ASC", 9), PRICE_DESC("PRICE", "DESC", 10);
	
	private String colName;
	private String direction;
	private int code;
	
	private RoomTableOrder(String colName, String direction, int code) {
		
		this.colName = colName;
		this.direction = direction;
		this.code = code;
	}

	public String getColName() {
		return colName;
	}
	public String getDirection() {
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
}
