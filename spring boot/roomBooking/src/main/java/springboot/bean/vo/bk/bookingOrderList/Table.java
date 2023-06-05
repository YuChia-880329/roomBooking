package springboot.bean.vo.bk.bookingOrderList;

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
