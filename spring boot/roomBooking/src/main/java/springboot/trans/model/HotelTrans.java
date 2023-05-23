package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelDto;
import springboot.bean.model.Hotel;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class HotelTrans implements ModelRiTrans<Hotel, HotelDto>, ModelWoTrans<Hotel, HotelDto> {

	@Override
	public Hotel dtoToModelImpl(HotelDto dto) {
		
		return null;
	}

	@Override
	public HotelDto modelToDtoImpl(Hotel model) {
		
		return null;
	}
}
