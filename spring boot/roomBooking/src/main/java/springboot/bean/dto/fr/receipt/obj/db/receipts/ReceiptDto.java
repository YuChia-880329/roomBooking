package springboot.bean.dto.fr.receipt.obj.db.receipts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.dao.fr.receipt.memory.repo.ReceiptRepoDao;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ReceiptDto {

	private int receiptId;
	private ReceiptRepoDao receiptRepoDao;
}
