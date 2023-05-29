package springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TableDto {

	private List<TableRowDto> tableRows;
}
