package springboot.bean.vo.bk.hotelInfo.allNewFeatures;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllNewFeaturesResp extends Data {

	private List<NewFeature> newFeatures;
}
