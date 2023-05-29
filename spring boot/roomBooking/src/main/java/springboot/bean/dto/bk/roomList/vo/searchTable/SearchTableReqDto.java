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

	private String name;
	private Integer totalNumMin;
	private Integer totalNumMax;
	private Integer usedNumMin;
	private Integer usedNumMax;
	private Integer invalidNumMin;
	private Integer invalidNumMax;
	private Integer priceMin;
	private Integer priceMax;
}
