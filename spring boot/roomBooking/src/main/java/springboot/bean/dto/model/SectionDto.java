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
@ToString(exclude = "hotels")
public class SectionDto {

	private String code;
	private String name;
	@JsonIgnore
	private List<HotelDto> hotels;
}
