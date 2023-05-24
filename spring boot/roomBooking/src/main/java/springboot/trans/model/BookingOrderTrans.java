package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.model.BookingOrder;
import springboot.trans.model.inner.BookingOrderTransInner;

@Component
public class BookingOrderTrans extends ModelTrans<BookingOrder, BookingOrderDto> {

	@Autowired
	private BookingOrderTransInner bookingOrderTransInner;
	
	@Autowired
	private MemberTrans memberTrans;
	@Autowired
	private RoomTrans roomTrans;
	@Autowired
	private PayMethodTrans payMethodTrans;
	
	
	@Override
	BookingOrder toModelRecrs(BookingOrderDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, bookingOrderTransInner::dtoToModel, cache::getBookingOrderCache, cache::setBookingOrderCache, model -> {
			
			model.setMember(memberTrans.toModelRecrs(dto.getMember(), cache));
			model.setRoom(roomTrans.toModelRecrs(dto.getRoom(), cache));
			model.setPayMethod(payMethodTrans.toModelRecrs(dto.getPayMethod(), cache));
		});
	}
	@Override
	BookingOrderDto toDtoRecrs(BookingOrder model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, bookingOrderTransInner::modelToDto, cache::getBookingOrderCache, cache::setBookingOrderCache, dto -> {
			
			dto.setMember(memberTrans.toDtoRecrs(model.getMember(), cache));
			dto.setRoom(roomTrans.toDtoRecrs(model.getRoom(), cache));
			dto.setPayMethod(payMethodTrans.toDtoRecrs(model.getPayMethod(), cache));
		});
	}
}
