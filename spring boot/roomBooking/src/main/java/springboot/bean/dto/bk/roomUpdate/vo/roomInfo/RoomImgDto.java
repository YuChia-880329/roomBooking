package springboot.bean.dto.bk.roomUpdate.vo.roomInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomImgDto {

	private String imgName;
	private String url;
	private int order;
}
