package springboot.bean.vo.bk.hotelInfo.allNewFeatures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class NewFeature {

	private int id;
	private String name;
}
