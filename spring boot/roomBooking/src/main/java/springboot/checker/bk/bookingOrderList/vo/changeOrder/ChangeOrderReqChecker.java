package springboot.checker.bk.bookingOrderList.vo.changeOrder;

import org.springframework.stereotype.Component;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import exception.check.StringIsNotOneOfException;
import springboot.bean.vo.bk.bookingOrderList.changeOrder.ChangeOrderReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.bookingOrderList.vo.changeOrder.ChangeOrderReqChecker")
public class ChangeOrderReqChecker implements Checker<ChangeOrderReq> {

	public static final String ORDER_FIELD_NAME = "順序";
	
	@Override
	public void check(ChangeOrderReq vo) {
		
		checkVo(vo);
		
		checkOrder(vo);
	}

	private void checkVo(ChangeOrderReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkOrder(ChangeOrderReq vo) {
		
		String order = vo.getOrder();
		
		try {
			
			CheckUtil.checkStringWithOptions(order, BookingOrderTableOrder.getCodeStrsArray());
		}catch (StringIsNotOneOfException ex) {
			
			throw new RiCheckerException(StringIsNotOneOfException.getMsgStr(ORDER_FIELD_NAME, BookingOrderTableOrder.getCodeStrsArray()));
		}
	}
}
