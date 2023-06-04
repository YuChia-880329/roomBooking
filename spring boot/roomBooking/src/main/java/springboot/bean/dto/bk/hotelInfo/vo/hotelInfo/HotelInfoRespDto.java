package springboot.bean.dto.bk.hotelInfo.vo.hotelInfo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelInfoRespDto {

	private String name;
	private String sectionCode;
	private String address;
	private String introduction;
	private List<Integer> featureIds;
	private List<String> newFeatureNames;
	private ImageDto image;
}
