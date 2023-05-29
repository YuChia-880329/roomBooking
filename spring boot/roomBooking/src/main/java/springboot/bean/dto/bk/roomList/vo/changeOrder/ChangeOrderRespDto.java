package springboot.bean.dto.bk.roomList.vo.changeOrder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.dto.bk.roomList.vo.TableDto;
import springboot.bean.dto.vo.PaginationDto;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ChangeOrderRespDto {

	private TableDto table;
	private PaginationDto pagination;
}
