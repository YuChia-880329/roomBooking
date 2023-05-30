package springboot.trans.bk.bookingOrderList.vo.allPayMethods;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.allPayMethods.PayMethodDto;
import springboot.bean.vo.bk.bookingOrderList.allPayMethods.PayMethod;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.bookingOrderList.vo.allPayMethods.PayMethodTrans")
public class PayMethodTrans implements VoWoTrans<PayMethod, PayMethodDto> {

	@Override
	public PayMethod dtoToVoImpl(PayMethodDto dto) {
		
		return PayMethod.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
