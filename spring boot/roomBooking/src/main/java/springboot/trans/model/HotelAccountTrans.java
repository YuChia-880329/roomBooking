package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.model.HotelAccount;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class HotelAccountTrans implements ModelRiTrans<HotelAccount, HotelAccountDto>, ModelWoTrans<HotelAccount, HotelAccountDto> {

	@Override
	public HotelAccount dtoToModelImpl(HotelAccountDto dto) {
		
		return null;
	}

	@Override
	public HotelAccountDto modelToDtoImpl(HotelAccount model) {
		
		return null;
	}
}
