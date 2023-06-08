package springboot.checker.bk.roomUpdate.vo.update;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.roomUpdate.update.RoomImg;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.roomUpdate.vo.update.RoomImgChecker")
public class RoomImgChecker implements Checker<RoomImg> {

	@Override
	public void check(RoomImg vo) {
		
		checkVo(vo);
		
		checkId(vo);
		checkOrder(vo);
	}

	private void checkVo(RoomImg vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkId(RoomImg vo) {
		
		int id = vo.getId();
		
		CheckUtil.checkNumberIsPositiveInteger(id);
	}
	private void checkOrder(RoomImg vo) {
		
		int order = vo.getOrder();
		
		CheckUtil.checkNumberIsPositiveInteger(order);
	}
}
