package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.PayMethodDto;
import springboot.bean.model.PayMethod;
import springboot.trans.model.inner.PayMethodTransInner;

@Component("model.PayMethodTrans")
public class PayMethodTrans extends ModelTrans<PayMethod, PayMethodDto> {

	@Autowired
	@Qualifier("model.inner.PayMethodTransInner")
	private PayMethodTransInner payMethodTransInner;
	
	@Autowired
	@Qualifier("model.BookingOrderTrans")
	private BookingOrderTrans bookingOrderTrans;
	

	@Override
	PayMethod toModelRecrs(PayMethodDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, payMethodTransInner::dtoToModel, cache::getPayMethodCache, cache::setPayMethodCache, model -> {
			
			model.setBookingOrders(bookingOrderTrans.toModelRecrs(dto.getBookingOrders(), cache));
		});
	}
	@Override
	PayMethodDto toDtoRecrs(PayMethod model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, payMethodTransInner::modelToDto, cache::getPayMethodCache, cache::setPayMethodCache, dto -> {
			
			dto.setBookingOrders(bookingOrderTrans.toDtoRecrs(model.getBookingOrders(), cache));
		});
	}
}
