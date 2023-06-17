package springboot.service.fr.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.receipt.obj.db.receipts.ReceiptDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.InputDto;
import springboot.bean.dto.fr.receipt.obj.repo.receipt.OutputDto;
import springboot.bean.dto.fr.receipt.vo.turnPage.TurnPageReqDto;
import springboot.bean.dto.fr.receipt.vo.turnPage.TurnPageRespDto;
import springboot.dao.fr.receipt.memory.db.ReceiptsDbDao;
import springboot.dao.fr.receipt.memory.repo.ReceiptRepoDao;
import springboot.memory.repo.fr.shoppingCart.ItemPagesRepo;
import springboot.service.PaginationService;

@Service("fr.receipt.TurnPageService")
public class TurnPageService {

	@Autowired
	@Qualifier("fr.receipt.memory.db.ReceiptsDbDao")
	private ReceiptsDbDao receiptsDbDao;
	@Autowired
	@Qualifier("fr.receipt.RepoService")
	private RepoService repoService;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	public TurnPageRespDto turnPage(TurnPageReqDto turnPageReq) {
		
		ReceiptDto receipt = receiptsDbDao.searchByPk(turnPageReq.getReceiptId());
		ReceiptRepoDao receiptRepoDao = receipt.getReceiptRepoDao();
		InputDto input = receiptRepoDao.getLastInput();
		input.getSearchParam().setPage(turnPageReq.getPage());
		OutputDto output = receiptRepoDao.getObj(input);
		
		return TurnPageRespDto.builder()
				.items(repoService.toItemVos(output.getItemPage().getItemList().getItems()))
				.pagination(paginationService.getPagination(output.getItemPage().getPage(), 
						ItemPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.totalPrice(output.getTotalPrice())
				.payMethod(repoService.toPayMethodVo(output.getPayMethod()))
				.build();
	}
}
