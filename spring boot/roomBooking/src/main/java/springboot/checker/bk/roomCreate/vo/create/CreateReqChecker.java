package springboot.checker.bk.roomCreate.vo.create;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.roomCreate.create.CreateReq;
import springboot.bean.vo.bk.roomCreate.create.NewImg;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.roomCreate.vo.create.UpdateReqChecker")
public class CreateReqChecker implements Checker<CreateReq> {

	@Autowired
	@Qualifier("bk.roomCreate.vo.create.NewImgChecker")
	private NewImgChecker newImgChecker;
	
	
	@Override
	public void check(CreateReq vo) {
		
		checkVo(vo);
		
		checkName(vo);
		checkTotalNum(vo);
		checkInvalidNum(vo);
		checkPrice(vo);
		checkSingleBedNum(vo);
		checkDoubleBedNum(vo);
		checkArea(vo);
		checkSceneId(vo);
		checkShowerIds(vo);
		checkStatusId(vo);
		checkNewImgs(vo);
	}
	
	private void checkVo(CreateReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkName(CreateReq vo) {
		
		String name = vo.getName();
		
		CheckUtil.checkString(name);
	}
	private void checkTotalNum(CreateReq vo) {
		
		int totalNum = vo.getTotalNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(totalNum);
	}
	private void checkInvalidNum(CreateReq vo) {
		
		int invalidNum = vo.getInvalidNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(invalidNum);
	}
	private void checkPrice(CreateReq vo) {
		
		int price = vo.getPrice();
		
		CheckUtil.checkNumberIsNonNegativeInteger(price);
	}
	private void checkSingleBedNum(CreateReq vo) {
		
		int singleBedNum = vo.getSingleBedNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(singleBedNum);
	}
	private void checkDoubleBedNum(CreateReq vo) {
		
		int doubleBedNum = vo.getDoubleBedNum();
		
		CheckUtil.checkNumberIsNonNegativeInteger(doubleBedNum);
	}
	private void checkArea(CreateReq vo) {
		
		int area = vo.getArea();
		
		CheckUtil.checkNumberIsNonNegativeInteger(area);
	}
	private void checkSceneId(CreateReq vo) {
		
		int sceneId = vo.getSceneId();
		
		CheckUtil.checkNumberIsPositiveInteger(sceneId);
	}
	private void checkShowerIds(CreateReq vo) {
		
		int[] showerIds = vo.getShowerIds();
		if(showerIds==null)
			return;
		
		Arrays.stream(showerIds)
			.forEach(si -> CheckUtil.checkNumberIsPositiveInteger(si));
	}
	private void checkStatusId(CreateReq vo) {
		
		int statusId = vo.getStatusId();
		
		CheckUtil.checkNumberIsNonNegativeInteger(statusId);
	}
	private void checkNewImgs(CreateReq vo) {
		
		NewImg[] newImgs = vo.getNewImgs();
		if(newImgs == null)
			return;
		
		Arrays.stream(newImgs)
			.forEach(ni -> newImgChecker.check(ni));
	}
}
