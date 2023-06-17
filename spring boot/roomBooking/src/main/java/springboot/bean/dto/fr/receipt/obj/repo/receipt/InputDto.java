package springboot.bean.dto.fr.receipt.obj.repo.receipt;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class InputDto {

	private SearchParamDto searchParam;
	private int totalPrice;
	private PayMethodInputDto payMethodInput;
}
