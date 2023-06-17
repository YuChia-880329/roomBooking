package springboot.bean.dto.fr.receipt.vo.turnPage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TurnPageReqDto {

	private int page;
	private int receiptId;
}
