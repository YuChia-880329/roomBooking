package springboot.bean.vo.bk.hotelInfo.hotelInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Image {

	private String imgName;
	private String url;
}
