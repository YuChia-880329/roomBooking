package springboot.bean.dto.bk.hotelInfo.vo.hotelInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ImageDto {

	private String imgName;
	private String url;
}
