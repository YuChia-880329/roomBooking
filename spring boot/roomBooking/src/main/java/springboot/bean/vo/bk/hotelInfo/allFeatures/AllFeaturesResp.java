package springboot.bean.vo.bk.hotelInfo.allFeatures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllFeaturesResp extends Data {

	private Feature[] features;
}
