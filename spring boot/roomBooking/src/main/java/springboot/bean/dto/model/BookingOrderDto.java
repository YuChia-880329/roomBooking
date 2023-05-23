package springboot.bean.dto.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class BookingOrderDto {

	private int id;
	private int clientId;
	private int roomId;
	private int roomNum;
	private int payMethodId;
	private LocalDateTime checkinDatetime;
	private LocalDate checkoutDate;
	private int useDay;
	private int totalMoney;
	private MemberDto member;
	private RoomDto room;
	private PayMethodDto payMethod;
}
