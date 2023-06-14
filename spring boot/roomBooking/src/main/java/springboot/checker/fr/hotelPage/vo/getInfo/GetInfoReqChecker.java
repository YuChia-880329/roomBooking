package springboot.checker.fr.hotelPage.vo.getInfo;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.hotelPage.getInfo.GetInfoReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.hotelPage.vo.getInfo.GetInfoReqChecker")
public class GetInfoReqChecker implements Checker<GetInfoReq> {

	@Override
	public void check(GetInfoReq vo) {
		
		checkVo(vo);
		
		checkHotelId(vo);
	}
	
	private void checkVo(GetInfoReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkHotelId(GetInfoReq vo) {
		
		String hotelId = vo.getHotelId();
		
		if(hotelId == null) {
			
			vo.setHotelId("1");
			hotelId = "1";
		}
		
		CheckUtil.checkStringIsPositiveIntegerNumberString(hotelId);
	}
}
