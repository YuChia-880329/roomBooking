package springboot.bean.obj.fr.receipt.db.receipts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.dao.fr.receipt.memory.repo.ReceiptRepoDao;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Receipt {

	private ReceiptRepoDao receiptRepoDao;
}
