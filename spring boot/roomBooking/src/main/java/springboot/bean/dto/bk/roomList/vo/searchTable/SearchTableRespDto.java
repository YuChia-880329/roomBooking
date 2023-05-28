package springboot.bean.dto.bk.roomList.vo.searchTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.dto.vo.PaginationDto;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchTableRespDto {

	private TableDto table;
	private PaginationDto pagination;
}
