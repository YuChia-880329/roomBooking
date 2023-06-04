package springboot.trans.bk.hotelInfo.vo.checkNewFeature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqDto;
import springboot.bean.vo.bk.hotelInfo.checkNewFeature.CheckNewFeatureReq;
import springboot.checker.bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqChecker;
import springboot.trans.VoRiTransChecked;

@Controller("bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqTrans")
public class CheckNewFeatureReqTrans extends VoRiTransChecked<CheckNewFeatureReq, CheckNewFeatureReqDto, CheckNewFeatureReqChecker> {

	@Override
	public CheckNewFeatureReqDto voToDtoImpl(CheckNewFeatureReq vo) {
		
		return CheckNewFeatureReqDto.builder()
				.name(vo.getName())
				.build();
	}

	@Autowired
	@Qualifier("bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqChecker")
	@Override
	public void setChecker(CheckNewFeatureReqChecker checker) {
		
		this.checker = checker;
	}

}
