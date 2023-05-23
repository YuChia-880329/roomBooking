package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.dto.model.MemberDto;
import springboot.bean.model.BookingOrder;
import springboot.bean.model.Member;
import springboot.trans.model.inner.BookingOrderTransInner;
import springboot.trans.model.inner.MemberTransInner;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class BookingOrderTrans implements ModelRiTrans<BookingOrder, BookingOrderDto>, ModelWoTrans<BookingOrder, BookingOrderDto> {

	@Autowired
	private BookingOrderTransInner bookingOrderTransInner;
	@Autowired
	private MemberTransInner memberTransInner;
	
	
	@Override
	public BookingOrder dtoToModelImpl(BookingOrderDto dto) {
		
		BookingOrder model = bookingOrderTransInner.dtoToModel(dto);
		
		model.setMember(null);
		model.setRoom(null);
		model.setPayMethod(null);
		
		return model;
	}

	@Override
	public BookingOrderDto modelToDtoImpl(BookingOrder model) {
		
		return null;
	}
	
	private Member toModel(MemberDto dto) {
		
		dto.getBookingOrders();
	}
}
