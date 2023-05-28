package springboot.bean.obj.bk.roomList.repo.tablePages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TableRow {

	private String name;
	private int totalNum;
	private int usedNum;
	private int invalidNum;
	private int price;
}
