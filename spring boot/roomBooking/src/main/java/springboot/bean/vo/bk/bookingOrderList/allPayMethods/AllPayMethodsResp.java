package springboot.bean.vo.bk.bookingOrderList.allPayMethods;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllPayMethodsResp extends Data {

	private List<PayMethod> payMethods;
}
