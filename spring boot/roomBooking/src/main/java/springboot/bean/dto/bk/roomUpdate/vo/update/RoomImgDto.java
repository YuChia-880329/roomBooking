package springboot.bean.dto.bk.roomUpdate.vo.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomImgDto {

	private int id;
	private int order;
}
