package springboot.memory.db.fr.receipt;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.obj.fr.receipt.db.receipts.Receipt;
import springboot.memory.db.MemoryDb;

@Component("fr.receipt.ReceiptsDb")
@SessionScope
public class ReceiptsDb extends MemoryDb<Integer, Receipt> {
}
