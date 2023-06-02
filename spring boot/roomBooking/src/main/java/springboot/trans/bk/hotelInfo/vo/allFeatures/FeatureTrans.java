package springboot.trans.bk.hotelInfo.vo.allFeatures;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.allFeatures.FeatureDto;
import springboot.bean.vo.bk.hotelInfo.allFeatures.Feature;
import tmpl.trans.bean.vo.VoWoTrans;


@Component("bk.hotelInfo.vo.allHotelFeatures.FeatureTrans")
public class FeatureTrans implements VoWoTrans<Feature, FeatureDto> {

	@Override
	public Feature dtoToVoImpl(FeatureDto dto) {
		
		return Feature.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
