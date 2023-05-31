package springboot.bean.dto.bk.hotelInfo.vo.allHotelFeatures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelFeatureDto {

	private int id;
	private String name;
	private boolean checked;
}
