package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.FeatureDto;
import springboot.bean.model.Feature;
import springboot.trans.model.inner.FeatureTransInner;

@Component("model.FeatureTrans")
public class FeatureTrans extends ModelTrans<Feature, FeatureDto> {

	@Autowired
	@Qualifier("model.inner.FeatureTransInner")
	private FeatureTransInner featureTransInner;
	
	@Autowired
	@Qualifier("model.HotelTrans")
	private HotelTrans hotelTrans;
	
	
	@Override
	Feature toModelRecrs(FeatureDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, featureTransInner::dtoToModel, cache::getHotelFeatureCache, cache::setHotelFeatureCache, model -> {
			
			model.setHotels(hotelTrans.toModelRecrs(dto.getHotels(), cache));
		});
	}
	@Override
	FeatureDto toDtoRecrs(Feature model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, featureTransInner::modelToDto, cache::getHotelFeatureCache, cache::setHotelFeatureCache, dto -> {
			
			dto.setHotels(hotelTrans.toDtoRecrs(model.getHotels(), cache));
		});
	}
}
