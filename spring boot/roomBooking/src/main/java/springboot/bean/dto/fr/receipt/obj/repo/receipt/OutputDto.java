package springboot.bean.dto.fr.receipt.obj.repo.receipt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class OutputDto {

	private int maxPage;
	private ItemPageDto itemPage;
	private int totalPrice;
	private PayMethodDto payMethod;
}
