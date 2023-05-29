package springboot.bean.obj.bk.bookingOrderList.repo.tablePages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TablePage {

	private Table table;
	private int currentPage;
}
