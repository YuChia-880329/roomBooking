package springboot.bean.vo.bk.roomList.searchTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;
import springboot.bean.vo.Pagination;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchTableResp extends Data {

	private Table table;
	private Pagination pagination;
}
