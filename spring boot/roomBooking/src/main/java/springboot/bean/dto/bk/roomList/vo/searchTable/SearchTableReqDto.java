package springboot.bean.dto.bk.roomList.vo.searchTable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchTableReqDto {

	private SearchParamDto searchParam;
}
