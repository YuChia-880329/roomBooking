package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelFeatureDto;
import springboot.bean.model.HotelFeature;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class HotelFeatureTrans implements ModelRiTrans<HotelFeature, HotelFeatureDto>, ModelWoTrans<HotelFeature, HotelFeatureDto> {

	@Override
	public HotelFeature dtoToModelImpl(HotelFeatureDto dto) {
		
		return null;
	}

	@Override
	public HotelFeatureDto modelToDtoImpl(HotelFeature model) {
		
		return null;
	}
}
