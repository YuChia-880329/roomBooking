package springboot.bean.dto.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = "hotel")
public class HotelAccountDto {

	private int id;
	private String account;
	private String password;
	private HotelDto hotel;
}
