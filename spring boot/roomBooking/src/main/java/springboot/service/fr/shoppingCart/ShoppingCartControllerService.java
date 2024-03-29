package springboot.service.fr.shoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.shoppingCart.checkout.CheckoutReq;
import springboot.bean.vo.fr.shoppingCart.delete.DeleteReq;
import springboot.bean.vo.fr.shoppingCart.turnPage.TurnPageReq;
import springboot.trans.fr.shoppingCart.vo.checkout.CheckoutReqTrans;
import springboot.trans.fr.shoppingCart.vo.checkout.CheckoutRespTrans;
import springboot.trans.fr.shoppingCart.vo.delete.DeleteReqTrans;
import springboot.trans.fr.shoppingCart.vo.delete.DeleteRespTrans;
import springboot.trans.fr.shoppingCart.vo.payMethodOptions.PayMethodOptionsRespTrans;
import springboot.trans.fr.shoppingCart.vo.show.ShowRespTrans;
import springboot.trans.fr.shoppingCart.vo.turnPage.TurnPageReqTrans;
import springboot.trans.fr.shoppingCart.vo.turnPage.TurnPageRespTrans;
import util.ResponseUtil;

@Service("fr.shoppingCart.ShoppingCartControllerService")
public class ShoppingCartControllerService {

	@Autowired
	@Qualifier("fr.shoppingCart.ShowService")
	private ShowService showService;
	@Autowired
	@Qualifier("fr.shoppingCart.DeleteService")
	private DeleteService deleteService;
	@Autowired
	@Qualifier("fr.shoppingCart.PayMethodOptionsService")
	private PayMethodOptionsService payMethodOptionsService;
	@Autowired
	@Qualifier("fr.shoppingCart.TurnPageService")
	private TurnPageService turnPageService;
	@Autowired
	@Qualifier("fr.shoppingCart.CheckoutService")
	private CheckoutService checkoutService;
	
	
	@Autowired
	@Qualifier("fr.shoppingCart.vo.show.ShowRespTrans")
	private ShowRespTrans showRespTrans;
	@Autowired
	@Qualifier("fr.shoppingCart.vo.delete.DeleteReqTrans")
	private DeleteReqTrans deleteReqTrans;
	@Autowired
	@Qualifier("fr.shoppingCart.vo.delete.DeleteRespTrans")
	private DeleteRespTrans deleteRespTrans;
	@Autowired
	@Qualifier("fr.shoppingCart.vo.payMethodOptions.PayMethodOptionsRespTrans")
	private PayMethodOptionsRespTrans payMethodOptionsRespTrans;
	@Autowired
	@Qualifier("fr.shoppingCart.vo.turnPage.TurnPageReqTrans")
	private TurnPageReqTrans turnPageReqTrans;
	@Autowired
	@Qualifier("fr.shoppingCart.vo.turnPage.TurnPageRespTrans")
	private TurnPageRespTrans turnPageRespTrans;
	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.CheckoutReqTrans")
	private CheckoutReqTrans checkoutReqTrans;
	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.CheckoutRespTrans")
	private CheckoutRespTrans checkoutRespTrans;
	
	
	
	public Response show() {
		
		return ResponseUtil.response200(
				showRespTrans.dtoToVo(
						showService.show()));
	}
	public Response delete(DeleteReq deleteReq) {
		
		return ResponseUtil.response200(
				deleteRespTrans.dtoToVo(
						deleteService.delete(
								deleteReqTrans.voToDto(deleteReq))));
	}
	public Response payMethodOptions() {
		
		return ResponseUtil.response200(
				payMethodOptionsRespTrans.dtoToVo(
						payMethodOptionsService.payMethodOptions()));
	}
	public Response turnPage(String page) {
		
		TurnPageReq turnPageReq = TurnPageReq.builder()
				.page(page)
				.build();
		
		return ResponseUtil.response200(
				turnPageRespTrans.dtoToVo(
						turnPageService.turnPage(
								turnPageReqTrans.voToDto(turnPageReq))));
	}
	public Response checkout(CheckoutReq checkoutReq) {
		
		return ResponseUtil.response200(
				checkoutRespTrans.dtoToVo(
						checkoutService.checkout(
								checkoutReqTrans.voToDto(checkoutReq))));
	}
}
