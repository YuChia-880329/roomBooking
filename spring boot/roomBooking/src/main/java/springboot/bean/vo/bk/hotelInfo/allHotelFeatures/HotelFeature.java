package springboot.bean.vo.bk.hotelInfo.allHotelFeatures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelFeature {

	private int id;
	private String name;
	private boolean checked;
}
