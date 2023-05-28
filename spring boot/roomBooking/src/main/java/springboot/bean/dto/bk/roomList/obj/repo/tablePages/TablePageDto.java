package springboot.bean.dto.bk.roomList.obj.repo.tablePages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TablePageDto {

	private TableDto table;
	private int currentPage;
}
