package springboot.checker.bk.hotelInfo.vo.CheckNewHotelFeatureReq;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.hotelInfo.checkNewHotelFeature.CheckNewHotelFeatureReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.hotelInfo.vo.CheckNewHotelFeatureReq.CheckNewHotelFeatureReqChecker")
public class CheckNewHotelFeatureReqChecker implements Checker<CheckNewHotelFeatureReq> {

	@Override
	public void check(CheckNewHotelFeatureReq vo) {
		
		checkVo(vo);
		
		checkName(vo);
	}

	public void checkVo(CheckNewHotelFeatureReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	public void checkName(CheckNewHotelFeatureReq vo) {
		
		String name = vo.getName();
		CheckUtil.checkString(name);
	}
}
