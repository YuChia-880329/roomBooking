package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelFeatureDto;
import springboot.bean.model.HotelFeature;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class HotelFeatureTransInner implements ModelRiTrans<HotelFeature, HotelFeatureDto>, ModelWoTrans<HotelFeature, HotelFeatureDto> {

	@Override
	public HotelFeature dtoToModelImpl(HotelFeatureDto dto) {
		
		return HotelFeature.builder()
				.id(dto.getId())
				.name(dto.getName())
				.hotels(null)
				.build();
	}

	@Override
	public HotelFeatureDto modelToDtoImpl(HotelFeature model) {
		
		return HotelFeatureDto.builder()
				.id(model.getId())
				.name(model.getName())
				.hotels(null)
				.build();
	}
}
