package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.model.HotelAccount;
import springboot.trans.model.inner.HotelAccountTransInner;

@Component
public class HotelAccountTrans extends ModelTrans<HotelAccount, HotelAccountDto> {

	@Autowired
	private HotelAccountTransInner hotelAccountTransInner;
	
	@Autowired
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
