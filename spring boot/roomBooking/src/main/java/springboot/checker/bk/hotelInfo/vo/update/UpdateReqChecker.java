package springboot.checker.bk.hotelInfo.vo.update;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.hotelInfo.update.UpdateReq;
import springboot.bean.vo.bk.roomList.turnPage.TurnPageReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.hotelInfo.vo.update.UpdateReqChecker")
public class UpdateReqChecker implements Checker<UpdateReq> {

	@Override
	public void check(UpdateReq vo) {
		
		checkVo(vo);
	}
	
	private void checkVo(UpdateReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkName(UpdateReq vo) {
		
		String name = vo.getName();
		CheckUtil.checkString(name);
	}
}
