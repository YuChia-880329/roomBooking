package springboot.bean.vo.bk.hotelInfo.checkNewFeature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckNewFeatureReq {

	private String name;
}
