package springboot.bean.dto.bk.hotelInfo.vo.checkNewHotelFeature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckNewHotelFeatureReqDto {

	private String name;
}
