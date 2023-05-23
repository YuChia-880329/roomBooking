package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.ShowerDto;
import springboot.bean.model.Shower;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class ShowerTrans implements ModelRiTrans<Shower, ShowerDto>, ModelWoTrans<Shower, ShowerDto> {

	@Override
	public Shower dtoToModelImpl(ShowerDto dto) {
		
		return null;
	}

	@Override
	public ShowerDto modelToDtoImpl(Shower model) {
		
		return null;
	}
}
