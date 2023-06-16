package springboot.bean.vo.fr.receipt.show;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;
import springboot.bean.vo.Pagination;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ShowResp extends Data {

	private Item[] items;
	private Pagination pagination;
	private int totalPrice;
	private PayMethod payMethod;
}
