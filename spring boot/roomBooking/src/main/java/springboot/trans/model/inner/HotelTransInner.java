package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelDto;
import springboot.bean.model.Hotel;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class HotelTransInner implements ModelRiTrans<Hotel, HotelDto>, ModelWoTrans<Hotel, HotelDto> {

	@Override
	public Hotel dtoToModelImpl(HotelDto dto) {
		
		return Hotel.builder()
				.id(dto.getId())
				.name(dto.getName())
				.sectionCode(dto.getSectionCode())
				.address(dto.getAddress())
				.introduction(dto.getIntroduction())
				.imgName(dto.getImgName())
				.accountId(dto.getAccountId())
				.section(null)
				.account(null)
				.features(null)
				.rooms(null)
				.build();
	}

	@Override
	public HotelDto modelToDtoImpl(Hotel model) {
		
		return HotelDto.builder()
				.id(model.getId())
				.name(model.getName())
				.sectionCode(model.getSectionCode())
				.address(model.getAddress())
				.introduction(model.getIntroduction())
				.imgName(model.getImgName())
				.accountId(model.getAccountId())
				.section(null)
				.account(null)
				.features(null)
				.rooms(null)
				.build();
	}
}
