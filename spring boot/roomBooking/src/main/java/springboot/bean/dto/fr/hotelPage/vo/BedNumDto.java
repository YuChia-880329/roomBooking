package springboot.bean.dto.fr.hotelPage.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class BedNumDto {

	private SingleBedNumDto singleBedNum;
	private DoubleBedNumDto doubleBedNum;
}
