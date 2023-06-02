package springboot.bean.dto.bk.hotelInfo.vo.allNewFeatures;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllNewFeaturesRespDto {

	private List<NewFeatureDto> newFeatures;
}
