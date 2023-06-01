package springboot.bean.vo.bk.hotelInfo.checkNewHotelFeature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckNewHotelFeatureResp extends Data {

	private boolean pass;
	private String msg;
}
