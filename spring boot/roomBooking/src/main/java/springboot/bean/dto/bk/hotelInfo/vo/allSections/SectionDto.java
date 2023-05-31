package springboot.bean.dto.bk.hotelInfo.vo.allSections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SectionDto {

	private String code;
	private String name;
}
