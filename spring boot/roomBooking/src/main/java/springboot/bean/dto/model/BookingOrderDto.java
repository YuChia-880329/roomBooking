package springboot.bean.dto.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class BookingOrderDto {

	private int id;
	private int clientId;
	private int roomId;
	private int roomNum;
	private int payMethodId;
	private LocalDate checkinDate;
	private LocalTime checkinTime;
	private LocalDate checkoutDate;
	private int useDay;
	private int totalMoney;
	private MemberDto member;
	private RoomDto room;
	private PayMethodDto payMethod;
}
