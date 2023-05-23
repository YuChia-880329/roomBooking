package springboot.bean.dto.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = "hotels")
public class HotelFeatureDto {

	private int id;
	private String name;
	private List<HotelDto> hotels;
}
