package springboot.dao.fr.receipt.memory.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.fr.receipt.obj.db.receipts.ReceiptDto;
import springboot.bean.obj.fr.receipt.db.receipts.Receipt;
import springboot.memory.db.MemoryDbDao;
import springboot.memory.db.fr.receipt.ReceiptsDb;
import springboot.trans.fr.receipt.obj.db.receipts.ReceiptsTrans;

@Repository("fr.receipt.memory.db.ReceiptsDbDao")
@SessionScope
public class ReceiptsDbDao extends MemoryDbDao<Integer, Receipt, ReceiptDto, ReceiptsDb, ReceiptsTrans> {

	protected ReceiptsDbDao(ReceiptsDb memory) {
		
		super(memory);
	}

	@Autowired
	@Qualifier("fr.receipt.obj.db.receipts.ReceiptsTrans")
	@Override
	protected void setTrans(ReceiptsTrans trans) {
		
		this.trans = trans;
	}
}
