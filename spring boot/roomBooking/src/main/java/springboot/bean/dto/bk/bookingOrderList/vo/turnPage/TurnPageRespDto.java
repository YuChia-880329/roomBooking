package springboot.bean.dto.bk.bookingOrderList.vo.turnPage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.dto.bk.bookingOrderList.vo.TableDto;
import springboot.bean.dto.vo.PaginationDto;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TurnPageRespDto {

	private TableDto table;
	private PaginationDto pagination;
}
