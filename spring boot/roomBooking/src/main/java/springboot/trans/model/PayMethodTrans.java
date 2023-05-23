package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.PayMethodDto;
import springboot.bean.model.PayMethod;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class PayMethodTrans implements ModelRiTrans<PayMethod, PayMethodDto>, ModelWoTrans<PayMethod, PayMethodDto> {

	@Override
	public PayMethod dtoToModelImpl(PayMethodDto dto) {
		
		return null;
	}

	@Override
	public PayMethodDto modelToDtoImpl(PayMethod model) {
		
		return null;
	}

}
