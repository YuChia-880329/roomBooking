package springboot.bean.vo.fr.receipt.turnPage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TurnPageReq {

	private String page;
	private String receiptId;
}
