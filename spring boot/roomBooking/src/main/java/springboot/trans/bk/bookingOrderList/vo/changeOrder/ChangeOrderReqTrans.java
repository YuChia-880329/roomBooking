package springboot.trans.bk.bookingOrderList.vo.changeOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.dto.bk.bookingOrderList.vo.changeOrder.ChangeOrderReqDto;
import springboot.bean.vo.bk.bookingOrderList.changeOrder.ChangeOrderReq;
import springboot.checker.bk.bookingOrderList.vo.changeOrder.ChangeOrderReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.bookingOrderList.vo.changeOrder.ChangeOrderReqTrans")
public class ChangeOrderReqTrans extends VoRiTransChecked<ChangeOrderReq, ChangeOrderReqDto, ChangeOrderReqChecker> {

	@Override
	public ChangeOrderReqDto voToDtoImpl(ChangeOrderReq vo) {
		
		return ChangeOrderReqDto.builder()
				.order(BookingOrderTableOrder.getByCode(Integer.parseInt(vo.getOrder())))
				.build();
	}

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.changeOrder.ChangeOrderReqChecker")
	@Override
	public void setChecker(ChangeOrderReqChecker checker) {
		
		this.checker = checker;
	}
}
