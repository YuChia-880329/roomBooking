package springboot.bean.vo.fr.hotelPage.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Features {

	private BedNum bedNum;
	private int area;
	private String sceneName;
	private Shower[] showers;
}
