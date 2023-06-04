package springboot.bean.dto.bk.hotelInfo.vo.checkNewFeature;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckNewFeatureRespDto {

	private boolean pass;
	private String msg;
}
