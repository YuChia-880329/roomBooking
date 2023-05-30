package springboot.bean.dto.bk.bookingOrderList.vo.allPayMethods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethodDto {

	private int id;
	private String name;
}
