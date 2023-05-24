package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelFeatureDto;
import springboot.bean.model.HotelFeature;
import springboot.trans.model.inner.HotelFeatureTransInner;

@Component
public class HotelFeatureTrans extends ModelTrans<HotelFeature, HotelFeatureDto> {

	@Autowired
	private HotelFeatureTransInner hotelFeatureTransInner;
	
	@Autowired
	private HotelTrans hotelTrans;
	
	
	@Override
	HotelFeature toModelRecrs(HotelFeatureDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, hotelFeatureTransInner::dtoToModel, cache::getHotelFeatureCache, cache::setHotelFeatureCache, model -> {
			
			model.setHotels(hotelTrans.toModelRecrs(dto.getHotels(), cache));
		});
	}
	@Override
	HotelFeatureDto toDtoRecrs(HotelFeature model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, hotelFeatureTransInner::modelToDto, cache::getHotelFeatureCache, cache::setHotelFeatureCache, dto -> {
			
			dto.setHotels(hotelTrans.toDtoRecrs(model.getHotels(), cache));
		});
	}
}
