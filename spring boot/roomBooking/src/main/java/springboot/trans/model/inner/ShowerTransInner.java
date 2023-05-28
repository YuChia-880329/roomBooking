package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.ShowerDto;
import springboot.bean.model.Shower;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component("model.inner.ShowerTransInner")
public class ShowerTransInner implements ModelRiTrans<Shower, ShowerDto>, ModelWoTrans<Shower, ShowerDto> {

	@Override
	public Shower dtoToModelImpl(ShowerDto dto) {
		
		return Shower.builder()
				.id(dto.getId())
				.name(dto.getName())
				.rooms(null)
				.build();
	}

	@Override
	public ShowerDto modelToDtoImpl(Shower model) {
		
		return ShowerDto.builder()
				.id(model.getId())
				.name(model.getName())
				.rooms(null)
				.build();
	}
}
