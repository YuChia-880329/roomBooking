package springboot.bean.dto.bk.roomList.vo.changeOrder;

import enumeration.bk.roomList.RoomTableOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ChangeOrderReqDto {

	private RoomTableOrder order;
}
