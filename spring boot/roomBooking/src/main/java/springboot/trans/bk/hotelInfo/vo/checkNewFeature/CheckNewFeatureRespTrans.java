package springboot.trans.bk.hotelInfo.vo.checkNewFeature;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureRespDto;
import springboot.bean.vo.bk.hotelInfo.checkNewFeature.CheckNewFeatureResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureRespTrans")
public class CheckNewFeatureRespTrans implements VoWoTrans<CheckNewFeatureResp, CheckNewFeatureRespDto> {

	@Override
	public CheckNewFeatureResp dtoToVoImpl(CheckNewFeatureRespDto dto) {
		
		return CheckNewFeatureResp.builder()
				.pass(dto.isPass())
				.msg(dto.getMsg())
				.build();
	}
}
