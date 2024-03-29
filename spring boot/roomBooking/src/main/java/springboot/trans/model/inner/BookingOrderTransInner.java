package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.model.BookingOrder;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;
import util.DateTimeUtil;

@Component("model.inner.BookingOrderTransInner")
public class BookingOrderTransInner implements ModelRiTrans<BookingOrder, BookingOrderDto>, ModelWoTrans<BookingOrder, BookingOrderDto> {

	@Override
	public BookingOrder dtoToModelImpl(BookingOrderDto dto) {
		
		return BookingOrder.builder()
				.id(dto.getId())
				.clientId(dto.getClientId())
				.roomId(dto.getRoomId())
				.roomNum(dto.getRoomNum())
				.payMethodId(dto.getPayMethodId())
				.checkinDate(DateTimeUtil.toDate(dto.getCheckinDate()))
				.checkinTime(DateTimeUtil.toTime(dto.getCheckinTime()))
				.checkoutDate(DateTimeUtil.toDate(dto.getCheckoutDate()))
				.useDay(dto.getUseDay())
				.totalMoney(dto.getTotalMoney())
				.member(null)
				.room(null)
				.payMethod(null)
				.build();
	}

	@Override
	public BookingOrderDto modelToDtoImpl(BookingOrder model) {
		
		return BookingOrderDto.builder()
				.id(model.getId())
				.clientId(model.getClientId())
				.roomId(model.getRoomId())
				.roomNum(model.getRoomNum())
				.payMethodId(model.getPayMethodId())
				.checkinDate(DateTimeUtil.toLocalDate(model.getCheckinDate()))
				.checkinTime(DateTimeUtil.toLocalTime(model.getCheckinTime()))
				.checkoutDate(DateTimeUtil.toLocalDate(model.getCheckoutDate()))
				.useDay(model.getUseDay())
				.totalMoney(model.getTotalMoney())
				.member(null)
				.room(null)
				.payMethod(null)
				.build();
	}
}
