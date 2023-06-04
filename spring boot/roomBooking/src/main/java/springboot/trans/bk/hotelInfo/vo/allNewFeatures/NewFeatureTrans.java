package springboot.trans.bk.hotelInfo.vo.allNewFeatures;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.allNewFeatures.NewFeatureDto;
import springboot.bean.vo.bk.hotelInfo.allNewFeatures.NewFeature;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.hotelInfo.vo.allNewFeatures.NewFeatureTrans")
public class NewFeatureTrans implements VoWoTrans<NewFeature, NewFeatureDto> {

	@Override
	public NewFeature dtoToVoImpl(NewFeatureDto dto) {
		
		return NewFeature.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}

}
