package springboot.bean.dto.fr.receipt.obj.repo.receipt;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ReceiptDto {

	private int maxPage;
	private Map<Integer, ItemPageDto> itemPageMap;
	private int totalPrice;
	private PayMethodDto payMethod;
}
