package springboot.bean.dto.fr.hotelPage.vo.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SingleBedNumDto {

	private boolean show;
	private int num;
}
