package springboot.bean.dto.bk.roomList.obj.repo.roomTableRows;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomTableRowDto {

	private String name;
	private int totalNum;
	private int usedNum;
	private int invalidNum;
	private int price;
}
