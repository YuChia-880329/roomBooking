package springboot.trans.bk.hotelInfo.vo.allNewFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.allNewFeatures.AllNewFeaturesRespDto;
import springboot.bean.vo.bk.hotelInfo.allNewFeatures.AllNewFeaturesResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.hotelInfo.vo.allNewFeatures.AllNewFeaturesRespTrans")
public class AllNewFeaturesRespTrans implements VoWoTrans<AllNewFeaturesResp, AllNewFeaturesRespDto> {

	@Autowired
	@Qualifier("bk.hotelInfo.vo.allNewFeatures.NewFeatureTrans")
	private NewFeatureTrans newFeatureTrans;

	@Override
	public AllNewFeaturesResp dtoToVoImpl(AllNewFeaturesRespDto dto) {
		
		return AllNewFeaturesResp.builder()
				.newFeatures(newFeatureTrans.dtoListToVoList(dto.getNewFeatures()))
				.build();
	}
}
