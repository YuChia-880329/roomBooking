package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.NewFeatureDto;
import springboot.bean.model.NewFeature;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component("model.inner.NewFeatureTransInner")
public class NewFeatureTransInner implements ModelRiTrans<NewFeature, NewFeatureDto>, ModelWoTrans<NewFeature, NewFeatureDto> {

	@Override
	public NewFeature dtoToModelImpl(NewFeatureDto dto) {
		
		return NewFeature.builder()
				.id(dto.getId())
				.name(dto.getName())
				.hotelId(dto.getHotelId())
				.checked(dto.isChecked() ? "1" : "0")
				.hotel(null)
				.build();
	}

	@Override
	public NewFeatureDto modelToDtoImpl(NewFeature model) {
		
		return NewFeatureDto.builder()
				.id(model.getId())
				.name(model.getName())
				.hotelId(model.getHotelId())
				.checked(model.getChecked().equals("1") ? true : false)
				.hotel(null)
				.build();
	}

}
