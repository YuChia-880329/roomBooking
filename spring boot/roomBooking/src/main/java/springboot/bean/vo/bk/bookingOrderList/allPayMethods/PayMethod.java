package springboot.bean.vo.bk.bookingOrderList.allPayMethods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethod {

	private int id;
	private String name;
}
