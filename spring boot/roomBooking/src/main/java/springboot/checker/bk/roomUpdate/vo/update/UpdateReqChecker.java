package springboot.checker.bk.roomUpdate.vo.update;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.roomUpdate.update.NewImg;
import springboot.bean.vo.bk.roomUpdate.update.RoomImg;
import springboot.bean.vo.bk.roomUpdate.update.UpdateReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.roomUpdate.vo.update.UpdateReqChecker")
public class UpdateReqChecker implements Checker<UpdateReq> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.RoomImgChecker")
	private RoomImgChecker roomImgChecker;
	@Autowired
	@Qualifier("bk.roomUpdate.vo.update.NewImgChecker")
	private NewImgChecker newImgChecker;
	
	
	@Override
	public void check(UpdateReq vo) {
		
		checkVo(vo);
		
		checkId(vo);
		checkName(vo);
		checkTotalNum(vo);
		checkUsedNum(vo);
		checkInvalidNum(vo);
		checkPrice(vo);
		checkSingleBedNum(vo);
		checkDoubleBedNum(vo);
		checkArea(vo);
		checkSceneId(vo);
		checkShowerIds(vo);
		checkStatusId(vo);
		checkRoomImgs(vo);
		checkNewImgs(vo);
	}
	
	private void checkVo(UpdateReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkId(UpdateReq vo) {
		
		int id = vo.getId();
		
		CheckUtil.checkNumberIsPositiveInteger(id);
	}
	private void checkName(UpdateReq vo) {
		
		String name = vo.getName();
		
		CheckUtil.checkString(name);
	}
	private void checkTotalNum(UpdateReq vo) {
		
		int totalNum = vo.getTotalNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(totalNum);
	}
	private void checkUsedNum(UpdateReq vo) {
		
		int usedNum = vo.getUsedNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(usedNum);
	}
	private void checkInvalidNum(UpdateReq vo) {
		
		int invalidNum = vo.getInvalidNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(invalidNum);
	}
	private void checkPrice(UpdateReq vo) {
		
		int price = vo.getPrice();
		
		CheckUtil.checkNumberIsNonNegativeInteger(price);
	}
	private void checkSingleBedNum(UpdateReq vo) {
		
		int singleBedNum = vo.getSingleBedNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(singleBedNum);
	}
	private void checkDoubleBedNum(UpdateReq vo) {
		
		int doubleBedNum = vo.getDoubleBedNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(doubleBedNum);
	}
	private void checkArea(UpdateReq vo) {
		
		int area = vo.getArea();
		
		CheckUtil.checkNumberIsNonNegativeInteger(area);
	}
	private void checkSceneId(UpdateReq vo) {
		
		int sceneId = vo.getSceneId();
		
		CheckUtil.checkNumberIsPositiveInteger(sceneId);
	}
	private void checkShowerIds(UpdateReq vo) {
		
		int[] showerIds = vo.getShowerIds();
		
		Arrays.stream(showerIds)
			.forEach(si -> CheckUtil.checkNumberIsPositiveInteger(si));
	}
	private void checkStatusId(UpdateReq vo) {
		
		int statusId = vo.getStatusId();
		
		CheckUtil.checkNumberIsPositiveInteger(statusId);
	}
	private void checkRoomImgs(UpdateReq vo) {
		
		RoomImg[] roomImgs = vo.getRoomImgs();
		
		Arrays.stream(roomImgs)
			.forEach(ri -> roomImgChecker.check(ri));
	}
	private void checkNewImgs(UpdateReq vo) {
		
		NewImg[] newImgs = vo.getNewImgs();
		
		Arrays.stream(newImgs)
			.forEach(ni -> newImgChecker.check(ni));
	}
}
