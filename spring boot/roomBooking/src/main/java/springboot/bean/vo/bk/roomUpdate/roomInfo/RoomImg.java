package springboot.bean.vo.bk.roomUpdate.roomInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomImg {

	private int id;
	private String imgName;
	private String url;
	private int order;
}
