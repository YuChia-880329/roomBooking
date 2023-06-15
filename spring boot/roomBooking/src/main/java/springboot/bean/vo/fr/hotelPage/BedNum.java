package springboot.bean.vo.fr.hotelPage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class BedNum {

	private SingleBedNum singleBedNum;
	private DoubleBedNum doubleBedNum;
}
