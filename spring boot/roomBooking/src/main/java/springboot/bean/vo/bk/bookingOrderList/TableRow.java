package springboot.bean.vo.bk.bookingOrderList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TableRow {

	private int id;
	private String clientName;
	private String clientPhone;
	private String roomName;
	private int roomNum;
	private int price;
	private String payMethod;
	private String checkinDate;
	private String checkoutDate;
	private int useDay;
	private int totalPrice;
}
