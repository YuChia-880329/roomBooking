package springboot.bean.dto.bk.roomList.vo;

import enumeration.RoomStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TableRowDto {

	private int index;
	private String name;
	private int totalNum;
	private int usedNum;
	private int invalidNum;
	private int price;
	private RoomStatus status;
}
