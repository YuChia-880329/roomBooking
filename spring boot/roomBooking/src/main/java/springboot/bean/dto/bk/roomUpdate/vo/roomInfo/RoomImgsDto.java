package springboot.bean.dto.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomImgsDto {

	private boolean hasImg;
	private List<RoomImgDto> imgs;
	private RoomImgDto currentImg;
}
