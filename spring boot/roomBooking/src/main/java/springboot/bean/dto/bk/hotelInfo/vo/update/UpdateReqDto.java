package springboot.bean.dto.bk.hotelInfo.vo.update;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class UpdateReqDto {

	private String name;
	private String sectionCode;
	private String address;
	private String description;
	private List<Integer> featureIds;
	private List<NewFeatureDto> newFeatures;
	private UpdateImageDto updateImage;
}
