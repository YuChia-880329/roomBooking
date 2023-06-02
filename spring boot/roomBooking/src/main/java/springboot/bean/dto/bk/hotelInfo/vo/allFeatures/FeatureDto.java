package springboot.bean.dto.bk.hotelInfo.vo.allFeatures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class FeatureDto {

	private int id;
	private String name;
}
