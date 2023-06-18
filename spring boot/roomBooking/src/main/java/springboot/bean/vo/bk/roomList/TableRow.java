package springboot.bean.vo.bk.roomList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TableRow {

	private int index;
	private String name;
	private int totalNum;
	private int invalidNum;
	private int price;
	private String status;
}
