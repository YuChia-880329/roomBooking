package springboot.checker.fr.hotelPage.vo.addShoppingCart;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.hotelPage.addShoppingCart.AddShoppingCartReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.hotelPage.vo.addShoppingCart.AddShoppingCartReqChecker")
public class AddShoppingCartReqChecker implements Checker<AddShoppingCartReq> {

	@Override
	public void check(AddShoppingCartReq vo) {
		
		checkVo(vo);
		
		checkRoomId(vo);
		checkNum(vo);
	}

	
	private void checkVo(AddShoppingCartReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkRoomId(AddShoppingCartReq vo) {
		
		int roomId = vo.getRoomId();
		CheckUtil.checkNumberIsPositiveInteger(roomId);
	}
	private void checkNum(AddShoppingCartReq vo) {
		
		int num = vo.getNum();
		CheckUtil.checkNumberIsPositiveInteger(num);
	}
}
