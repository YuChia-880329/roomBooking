package springboot.bean.vo.bk.roomList.searchTable;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Table {

	private List<TableRow> tableRows;
}
