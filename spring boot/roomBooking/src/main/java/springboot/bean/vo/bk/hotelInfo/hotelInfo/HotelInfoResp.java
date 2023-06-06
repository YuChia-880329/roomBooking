package springboot.bean.vo.bk.hotelInfo.hotelInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelInfoResp extends Data {

	private String name;
	private String sectionCode;
	private String address;
	private String description;
	private int[] featureIds;
	private String[] newFeatureNames;
	private Image image;
}
