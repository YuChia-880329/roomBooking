package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.model.HotelAccount;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component("model.inner.HotelAccountTransInner")
public class HotelAccountTransInner implements ModelRiTrans<HotelAccount, HotelAccountDto>, ModelWoTrans<HotelAccount, HotelAccountDto> {

	@Override
	public HotelAccount dtoToModelImpl(HotelAccountDto dto) {
		
		return HotelAccount.builder()
				.id(dto.getId())
				.account(dto.getAccount())
				.password(dto.getPassword())
				.hotel(null)
				.build();
	}

	@Override
	public HotelAccountDto modelToDtoImpl(HotelAccount model) {
		
		return HotelAccountDto.builder()
				.id(model.getId())
				.account(model.getAccount())
				.password(model.getPassword())
				.hotel(null)
				.build();
	}
}
