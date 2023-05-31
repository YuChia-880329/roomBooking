package springboot.bean.dto.bk.bookingOrderList.vo.changeOrder;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ChangeOrderReqDto {

	private BookingOrderTableOrder order;
}
