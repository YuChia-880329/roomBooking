package springboot.trans.bk.hotelInfo.vo.checkNewHotelFeature;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureRespDto;
import springboot.bean.vo.bk.hotelInfo.checkNewHotelFeature.CheckNewHotelFeatureResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureRespTrans")
public class CheckNewHotelFeatureRespTrans implements VoWoTrans<CheckNewHotelFeatureResp, CheckNewHotelFeatureRespDto> {

	@Override
	public CheckNewHotelFeatureResp dtoToVoImpl(CheckNewHotelFeatureRespDto dto) {
		
		return CheckNewHotelFeatureResp.builder()
				.pass(dto.isPass())
				.msg(dto.getMsg())
				.build();
	}
}
