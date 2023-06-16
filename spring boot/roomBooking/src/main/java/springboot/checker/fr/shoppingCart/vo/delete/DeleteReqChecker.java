package springboot.checker.fr.shoppingCart.vo.delete;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.shoppingCart.delete.DeleteReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.shoppingCart.vo.delete.DeleteReqChecker")
public class DeleteReqChecker implements Checker<DeleteReq> {

	@Override
	public void check(DeleteReq vo) {
		
		checkVo(vo);
		
		checkItemId(vo);
	}
	
	private void checkVo(DeleteReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkItemId(DeleteReq vo) {
		
		int itemId = vo.getItemId();
		
		CheckUtil.checkNumberIsNonNegativeInteger(itemId);
	}
}
