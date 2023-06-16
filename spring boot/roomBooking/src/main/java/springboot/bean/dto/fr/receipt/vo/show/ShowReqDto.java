package springboot.bean.dto.fr.receipt.vo.show;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ShowReqDto {

	private int receiptId;
}
