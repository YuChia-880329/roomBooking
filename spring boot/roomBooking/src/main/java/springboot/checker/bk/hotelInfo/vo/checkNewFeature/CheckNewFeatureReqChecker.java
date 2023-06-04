package springboot.checker.bk.hotelInfo.vo.checkNewFeature;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.hotelInfo.checkNewFeature.CheckNewFeatureReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqChecker")
public class CheckNewFeatureReqChecker implements Checker<CheckNewFeatureReq> {

	@Override
	public void check(CheckNewFeatureReq vo) {
		
		checkVo(vo);
		
		checkName(vo);
	}

	public void checkVo(CheckNewFeatureReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	public void checkName(CheckNewFeatureReq vo) {
		
		String name = vo.getName();
		CheckUtil.checkString(name);
	}
}
