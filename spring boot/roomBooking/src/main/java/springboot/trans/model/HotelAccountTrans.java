package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.model.HotelAccount;
import springboot.trans.model.inner.HotelAccountTransInner;

@Component("model.HotelAccountTrans")
public class HotelAccountTrans extends ModelTrans<HotelAccount, HotelAccountDto> {

	@Autowired
	@Qualifier("model.inner.HotelAccountTransInner")
	private HotelAccountTransInner hotelAccountTransInner;
	
	@Autowired
	@Qualifier("model.HotelTrans")
	private HotelTrans hotelTrans;
	
	
	@Override
	HotelAccount toModelRecrs(HotelAccountDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, hotelAccountTransInner::dtoToModel, cache::getHotelAccountCache, cache::setHotelAccountCache, model -> {
			
			model.setHotel(hotelTrans.toModelRecrs(dto.getHotel(), cache));
		});
	}
	@Override
	HotelAccountDto toDtoRecrs(HotelAccount model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, hotelAccountTransInner::modelToDto, cache::getHotelAccountCache, cache::setHotelAccountCache, dto -> {
			
			dto.setHotel(hotelTrans.toDtoRecrs(model.getHotel(), cache));
		});
	}
}
