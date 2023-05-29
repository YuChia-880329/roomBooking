package springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class OutputDto {

	private int maxPage;
	private TablePageDto tablePage;
}
