package springboot.bean.obj.fr.receipt.repo.receipt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Output {

	private int maxPage;
	private ItemPage itemPage;
	private int totalPrice;
	private PayMethod payMethod;
}
