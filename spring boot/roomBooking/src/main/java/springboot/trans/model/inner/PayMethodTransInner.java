package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.PayMethodDto;
import springboot.bean.model.PayMethod;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component("model.inner.PayMethodTransInner")
public class PayMethodTransInner implements ModelRiTrans<PayMethod, PayMethodDto>, ModelWoTrans<PayMethod, PayMethodDto> {

	@Override
	public PayMethod dtoToModelImpl(PayMethodDto dto) {
		
		return PayMethod.builder()
				.id(dto.getId())
				.name(dto.getName())
				.bookingOrders(null)
				.build();
	}

	@Override
	public PayMethodDto modelToDtoImpl(PayMethod model) {
		
		return PayMethodDto.builder()
				.id(model.getId())
				.name(model.getName())
				.bookingOrders(null)
				.build();
	}

}
