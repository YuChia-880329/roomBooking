package springboot.trans.bk.hotelInfo.vo.checkNewHotelFeature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureReqDto;
import springboot.bean.vo.bk.hotelInfo.checkNewHotelFeature.CheckNewHotelFeatureReq;
import springboot.checker.bk.hotelInfo.vo.CheckNewHotelFeatureReq.CheckNewHotelFeatureReqChecker;
import springboot.trans.VoRiTransChecked;

@Controller("bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureReqTrans")
public class CheckNewHotelFeatureReqTrans extends VoRiTransChecked<CheckNewHotelFeatureReq, CheckNewHotelFeatureReqDto, CheckNewHotelFeatureReqChecker> {

	@Override
	public CheckNewHotelFeatureReqDto voToDtoImpl(CheckNewHotelFeatureReq vo) {
		
		return CheckNewHotelFeatureReqDto.builder()
				.name(vo.getName())
				.build();
	}

	@Autowired
	@Qualifier("bk.hotelInfo.vo.CheckNewHotelFeatureReq.CheckNewHotelFeatureReqChecker")
	@Override
	public void setChecker(CheckNewHotelFeatureReqChecker checker) {
		
		this.checker = checker;
	}

}
