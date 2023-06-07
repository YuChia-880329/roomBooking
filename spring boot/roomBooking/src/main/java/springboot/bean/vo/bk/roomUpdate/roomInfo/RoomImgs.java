package springboot.bean.vo.bk.roomUpdate.roomInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomImgs {

	private boolean hasImg;
	private RoomImg[] imgs;
	private RoomImg currentImg;
}
