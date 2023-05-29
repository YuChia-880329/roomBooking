package springboot.bean.vo.bk.roomList.changeOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;
import springboot.bean.vo.Pagination;
import springboot.bean.vo.bk.roomList.Table;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ChangeOrderResp extends Data {

	private Table table;
	private Pagination pagination;
}
