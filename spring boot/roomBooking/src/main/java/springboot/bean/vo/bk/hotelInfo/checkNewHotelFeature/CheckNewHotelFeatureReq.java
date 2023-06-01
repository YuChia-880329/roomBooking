package springboot.bean.vo.bk.hotelInfo.checkNewHotelFeature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckNewHotelFeatureReq {

	private String name;
}
