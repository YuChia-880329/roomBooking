package springboot.trans.bk.hotelInfo.vo.allFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.allFeatures.AllFeaturesRespDto;
import springboot.bean.vo.bk.hotelInfo.allFeatures.AllFeaturesResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.hotelInfo.vo.allHotelFeatures.AllFeaturesRespTrans")
public class AllFeaturesRespTrans implements VoWoTrans<AllFeaturesResp, AllFeaturesRespDto> {

	@Autowired
	@Qualifier("bk.hotelInfo.vo.allHotelFeatures.FeatureTrans")
	private FeatureTrans featureTrans;
	
	@Override
	public AllFeaturesResp dtoToVoImpl(AllFeaturesRespDto dto) {
		
		return AllFeaturesResp.builder()
				.features(featureTrans.dtoListToVoList(dto.getFeatures()))
				.build();
	}
}
