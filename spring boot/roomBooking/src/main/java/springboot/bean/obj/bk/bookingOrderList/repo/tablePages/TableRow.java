package springboot.bean.obj.bk.bookingOrderList.repo.tablePages;

import java.time.LocalDate;

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
	private LocalDate checkinDate;
	private LocalDate checkoutDate;
	private int useDay;
	private int totalPrice;
}
