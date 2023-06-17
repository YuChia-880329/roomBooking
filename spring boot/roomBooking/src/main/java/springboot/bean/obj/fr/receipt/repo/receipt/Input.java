package springboot.bean.obj.fr.receipt.repo.receipt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Input {

	private SearchParam searchParam;
	private int totalPrice;
	private PayMethodInput payMethodInput;
}
