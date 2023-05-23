package springboot.bean.dto.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = "bookingOrders")
public class MemberDto {

	private int id;
	private String account;
	private String password;
	private String name;
	private String phone;
	private List<BookingOrderDto> bookingOrders;
}
