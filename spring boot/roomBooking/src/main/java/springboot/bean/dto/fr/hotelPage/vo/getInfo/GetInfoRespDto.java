package springboot.bean.dto.fr.hotelPage.vo.getInfo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class GetInfoRespDto {
	
	private String imgUrl;
	private String hotelName;
	private String address;
	private String description;
    private List<FeatureDto> features;
}
