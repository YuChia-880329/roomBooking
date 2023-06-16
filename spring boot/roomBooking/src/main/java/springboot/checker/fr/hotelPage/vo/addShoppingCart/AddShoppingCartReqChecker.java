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
		checkCheckinDate(vo);
		checkCheckoutDate(vo);
		checkCheckinTime(vo);
		checkNum(vo);
		checkPrice(vo);
	}

	
	private void checkVo(AddShoppingCartReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkRoomId(AddShoppingCartReq vo) {
		
		int roomId = vo.getRoomId();
		CheckUtil.checkNumberIsPositiveInteger(roomId);
	}
	private void checkCheckinDate(AddShoppingCartReq vo) {
		
		String checkinDate = vo.getCheckinDate();
		CheckUtil.checkString(checkinDate);
	}
	private void checkCheckoutDate(AddShoppingCartReq vo) {
		
		String checkoutDate = vo.getCheckoutDate();
		CheckUtil.checkString(checkoutDate);
	}
	private void checkCheckinTime(AddShoppingCartReq vo) {
		
		String checkinTime = vo.getCheckinTime();
		CheckUtil.checkString(checkinTime);
	}
	private void checkNum(AddShoppingCartReq vo) {
		
		int num = vo.getNum();
		CheckUtil.checkNumberIsPositiveInteger(num);
	}
	private void checkPrice(AddShoppingCartReq vo) {
		
		int price = vo.getPrice();
		CheckUtil.checkNumberIsPositiveInteger(price);
	}
}
