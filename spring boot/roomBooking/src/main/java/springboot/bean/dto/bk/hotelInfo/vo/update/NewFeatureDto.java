package springboot.bean.dto.bk.hotelInfo.vo.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class NewFeatureDto {

	int id;
	String name;
}
