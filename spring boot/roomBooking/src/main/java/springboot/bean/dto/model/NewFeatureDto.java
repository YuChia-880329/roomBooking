package springboot.bean.dto.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class NewFeatureDto {

	private int id;
	private String name;
	private int hotelId;
	private boolean checked;
	private HotelDto hotel;
}
