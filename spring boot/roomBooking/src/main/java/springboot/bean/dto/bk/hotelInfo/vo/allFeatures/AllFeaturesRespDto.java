package springboot.bean.dto.bk.hotelInfo.vo.allFeatures;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllFeaturesRespDto {

	private List<FeatureDto> features;
}
