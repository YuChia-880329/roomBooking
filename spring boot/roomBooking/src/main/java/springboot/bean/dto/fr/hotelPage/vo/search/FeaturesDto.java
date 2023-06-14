package springboot.bean.dto.fr.hotelPage.vo.search;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class FeaturesDto {

	private BedNumDto bedNum;
	private int area;
	private String sceneName;
	private List<ShowerDto> showers;
}
