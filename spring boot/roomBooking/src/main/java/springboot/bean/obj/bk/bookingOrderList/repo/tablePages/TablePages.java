package springboot.bean.obj.bk.bookingOrderList.repo.tablePages;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TablePages {

	private int maxPage;
	private Map<Integer, TablePage> tablePageMap;
}
