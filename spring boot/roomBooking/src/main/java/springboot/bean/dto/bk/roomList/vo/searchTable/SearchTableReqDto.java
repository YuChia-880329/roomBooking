package springboot.bean.dto.bk.roomList.vo.searchTable;

import enumeration.RoomStatus;
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
	private Integer invalidNumMin;
	private Integer invalidNumMax;
	private Integer priceMin;
	private Integer priceMax;
	private RoomStatus status;
}
