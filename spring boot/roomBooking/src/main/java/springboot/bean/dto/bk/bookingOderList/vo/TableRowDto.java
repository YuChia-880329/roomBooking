package springboot.bean.dto.bk.bookingOderList.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TableRowDto {

	private int id;
	private String clientName;
	private String clientPhone;
	private String roomName;
	private int roomNum;
	private int price;
	private String payMethod;
	private LocalDateTime checkinDateTime;
	private LocalDate checkoutDate;
	private int useDay;
	private int totalPrice;
}
