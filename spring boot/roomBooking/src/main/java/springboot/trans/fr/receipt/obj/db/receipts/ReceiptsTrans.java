package springboot.trans.fr.receipt.obj.db.receipts;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.receipt.obj.db.receipts.ReceiptDto;
import springboot.bean.obj.fr.receipt.db.receipts.Receipt;
import springboot.memory.db.MemoryDbTrans;
import springboot.memory.db.PkAndObj;

@Component("fr.receipt.obj.db.receipts.ReceiptsTrans")
public class ReceiptsTrans extends MemoryDbTrans<Integer, Receipt, ReceiptDto> {

	@Override
	protected Integer dtoToPkImpl(ReceiptDto dto) {
		
		return dto.getReceiptId();
	}

	@Override
	protected Receipt dtoToObjImpl(ReceiptDto dto) {
		
		return Receipt.builder()
				.receiptRepoDao(dto.getReceiptRepoDao())
				.build();
	}

	@Override
	protected ReceiptDto paoToDtoImpl(PkAndObj<Integer, Receipt> pao) {
		
		return ReceiptDto.builder()
				.receiptId(pao.getPk())
				.receiptRepoDao(pao.getObj().getReceiptRepoDao())
				.build();
	}

}
