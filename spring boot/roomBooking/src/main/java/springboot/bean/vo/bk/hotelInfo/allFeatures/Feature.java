package springboot.bean.vo.bk.hotelInfo.allFeatures;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Feature {

	private int id;
	private String name;
}
