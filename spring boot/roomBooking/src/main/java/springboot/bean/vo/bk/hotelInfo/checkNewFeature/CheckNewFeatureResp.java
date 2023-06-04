package springboot.bean.vo.bk.hotelInfo.checkNewFeature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckNewFeatureResp extends Data {

	private boolean pass;
	private String msg;
}
