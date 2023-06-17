package springboot.bean.obj.fr.receipt.repo.receipt;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Receipt {
	
	private int maxPage;
	private Map<Integer, ItemPage> itemPageMap;
	private int totalPrice;
	private PayMethod payMethod;
}
