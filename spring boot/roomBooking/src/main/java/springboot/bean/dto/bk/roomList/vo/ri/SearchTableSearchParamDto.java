package springboot.bean.dto.bk.roomList.vo.ri;

import enumeration.bk.roomList.RoomTableOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchTableSearchParamDto {

	private int page;
	private String name;
	private Integer totalNumMin;
	private Integer totalNumMax;
	private Integer usedNumMin;
	private Integer usedNumMax;
	private Integer invalidNumMin;
	private Integer invalidNumMax;
	private Integer priceMin;
	private Integer priceMax;
	private RoomTableOrder order;
}
