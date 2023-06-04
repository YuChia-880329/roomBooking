package springboot.bean.dto.bk.hotelInfo.vo.allNewFeatures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class NewFeatureDto {

	private int id;
	private String name;
}
