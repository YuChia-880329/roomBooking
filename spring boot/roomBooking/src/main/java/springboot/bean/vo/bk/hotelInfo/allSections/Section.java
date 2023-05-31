package springboot.bean.vo.bk.hotelInfo.allSections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Section {

	private String code;
	private String name;
}
