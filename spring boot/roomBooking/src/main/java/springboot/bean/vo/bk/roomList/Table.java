package springboot.bean.vo.bk.roomList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Table {

	private TableRow[] tableRows;
}
