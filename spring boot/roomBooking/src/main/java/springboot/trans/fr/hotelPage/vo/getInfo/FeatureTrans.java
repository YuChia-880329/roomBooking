package springboot.trans.fr.hotelPage.vo.getInfo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.getInfo.FeatureDto;
import springboot.bean.vo.fr.hotelPage.getInfo.Feature;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.getInfo.FeatureTrans")
public class FeatureTrans implements VoWoTrans<Feature, FeatureDto> {

	@Override
	public Feature dtoToVoImpl(FeatureDto dto) {
		
		return Feature.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
