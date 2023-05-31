package springboot.bean.dto.bk.hotelInfo.vo.allHotelFeatures;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllHotelFeaturesRespDto {

	private List<HotelFeatureDto> hotelFeatures;
}
