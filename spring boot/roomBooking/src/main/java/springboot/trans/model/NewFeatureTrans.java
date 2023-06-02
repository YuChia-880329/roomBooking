package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.NewFeatureDto;
import springboot.bean.model.NewFeature;
import springboot.trans.model.inner.NewFeatureTransInner;

@Component("model.NewFeatureTrans")
public class NewFeatureTrans extends ModelTrans<NewFeature, NewFeatureDto> {

	@Autowired
	@Qualifier("model.inner.NewFeatureTransInner")
	private NewFeatureTransInner newFeatureTransInner;
	
	@Autowired
	@Qualifier("model.HotelTrans")
	private HotelTrans hotelTrans;
	
	
	@Override
	NewFeature toModelRecrs(NewFeatureDto dto, ToModelRecrsCache cache) {

		return toModelRecrs(dto, newFeatureTransInner::dtoToModel, cache::getNewFeatureCache, cache::setNewFeatureCache, model -> {
			
			model.setHotel(hotelTrans.toModelRecrs(dto.getHotel(), cache));
		});
	}

	@Override
	NewFeatureDto toDtoRecrs(NewFeature model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, newFeatureTransInner::modelToDto, cache::getNewFeatureCache, cache::setNewFeatureCache, dto -> {
			
			dto.setHotel(hotelTrans.toDtoRecrs(model.getHotel(), cache));
		});
	}

}
