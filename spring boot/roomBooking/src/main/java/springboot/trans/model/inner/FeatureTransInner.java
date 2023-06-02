package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.FeatureDto;
import springboot.bean.model.Feature;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component("model.inner.FeatureTransInner")
public class FeatureTransInner implements ModelRiTrans<Feature, FeatureDto>, ModelWoTrans<Feature, FeatureDto> {

	@Override
	public Feature dtoToModelImpl(FeatureDto dto) {
		
		return Feature.builder()
				.id(dto.getId())
				.name(dto.getName())
				.hotels(null)
				.build();
	}

	@Override
	public FeatureDto modelToDtoImpl(Feature model) {
		
		return FeatureDto.builder()
				.id(model.getId())
				.name(model.getName())
				.hotels(null)
				.build();
	}
}
