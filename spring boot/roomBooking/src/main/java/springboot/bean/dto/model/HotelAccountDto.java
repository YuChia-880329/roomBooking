package springboot.bean.dto.model;

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
@ToString(exclude = "hotel")
public class HotelAccountDto {

	private int id;
	private String account;
	private String password;
	@JsonIgnore
	private HotelDto hotel;
}
