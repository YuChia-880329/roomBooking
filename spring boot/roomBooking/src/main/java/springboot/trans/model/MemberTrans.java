package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.MemberDto;
import springboot.bean.model.Member;
import springboot.trans.model.inner.MemberTransInner;

@Component
public class MemberTrans extends ModelTrans<Member, MemberDto> {

	@Autowired
	private MemberTransInner memberTransInner;
	
	@Autowired
	private BookingOrderTrans bookingOrderTrans;
	
	
	@Override
	Member toModelRecrs(MemberDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, memberTransInner::dtoToModel, cache::getMemberCache, cache::setMemberCache, model -> {
			
			model.setBookingOrders(bookingOrderTrans.toModelRecrs(dto.getBookingOrders(), cache));
		});
	}
	@Override
	MemberDto toDtoRecrs(Member model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, memberTransInner::modelToDto, cache::getMemberCache, cache::setMemberCache, dto -> {
			
			dto.setBookingOrders(bookingOrderTrans.toDtoRecrs(model.getBookingOrders(), cache));
		});
	}
}
