package springboot.bean.obj.bk.roomList.repo.tablePages;

import enumeration.RoomStatus;
import enumeration.bk.roomList.RoomTableOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchParam {

	private int page;
	private String name;
	private Integer totalNumMin;
	private Integer totalNumMax;
	private Integer invalidNumMin;
	private Integer invalidNumMax;
	private Integer priceMin;
	private Integer priceMax;
	private RoomStatus status;
	private RoomTableOrder roomTableOrder;
}
