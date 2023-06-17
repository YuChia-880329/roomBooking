package springboot.service.fr.receipt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.receipt.show.ShowReq;
import springboot.bean.vo.fr.receipt.turnPage.TurnPageReq;
import springboot.trans.fr.receipt.vo.show.ShowReqTrans;
import springboot.trans.fr.receipt.vo.show.ShowRespTrans;
import springboot.trans.fr.receipt.vo.turnPage.TurnPageReqTrans;
import springboot.trans.fr.receipt.vo.turnPage.TurnPageRespTrans;
import util.ResponseUtil;

@Service("fr.receipt.ReceiptControllerService")
public class ReceiptControllerService {

	@Autowired
	@Qualifier("fr.receipt.ShowService")
	private ShowService showService;
	@Autowired
	@Qualifier("fr.receipt.TurnPageService")
	private TurnPageService turnPageService;
	
	
	@Autowired
	@Qualifier("fr.receipt.vo.show.ShowReqTrans")
	private ShowReqTrans showReqTrans;
	@Autowired
	@Qualifier("fr.receipt.vo.show.ShowResp")
	private ShowRespTrans showRespTrans;
	@Autowired
	@Qualifier("fr.receipt.vo.turnPage.TurnPageReqTrans")
	private TurnPageReqTrans turnPageReqTrans;
	@Autowired
	@Qualifier("fr.receipt.vo.turnPage.TurnPageRespTrans")
	private TurnPageRespTrans turnPageRespTrans;
	
	
	
	public Response show(String receiptId) {
		
		ShowReq showReq = ShowReq.builder()
				.receiptId(receiptId)
				.build();
		return ResponseUtil.response200(
				showRespTrans.dtoToVo(
						showService.show(
								showReqTrans.voToDto(showReq))));
	}
	
	public Response turnPage(String page, String receiptId) {
		
		TurnPageReq turnPageReq = TurnPageReq.builder()
				.page(page)
				.receiptId(receiptId)
				.build();
		return ResponseUtil.response200(
				turnPageRespTrans.dtoToVo(
						turnPageService.turnPage(
								turnPageReqTrans.voToDto(turnPageReq))));
	}
}
