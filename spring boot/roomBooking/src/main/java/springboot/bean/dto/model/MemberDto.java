package springboot.bean.dto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "bookingOrders")
public class MemberDto {

	private int id;
	private String account;
	private String password;
	private String name;
	private String phone;
	@JsonIgnore
	private List<BookingOrderDto> bookingOrders;
}
