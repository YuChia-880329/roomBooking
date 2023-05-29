package springboot.trans.bk.roomList.vo.changeOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.dto.bk.roomList.vo.changeOrder.ChangeOrderReqDto;
import springboot.bean.vo.bk.roomList.changeOrder.ChangeOrderReq;
import springboot.checker.bk.roomList.vo.changeOrder.ChangeOrderReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomList.vo.changeOrder.ChangeOrderReqTrans")
public class ChangeOrderReqTrans extends VoRiTransChecked<ChangeOrderReq, ChangeOrderReqDto, ChangeOrderReqChecker> {

	@Override
	public ChangeOrderReqDto voToDtoImpl(ChangeOrderReq vo) {
		
		return ChangeOrderReqDto.builder()
				.order(RoomTableOrder.getByCode(Integer.parseInt(vo.getOrder())))
				.build();
	}

	@Autowired
	@Qualifier("bk.roomList.vo.changeOrder.ChangeOrderReqChecker")
	@Override
	public void setChecker(ChangeOrderReqChecker checker) {
		
		this.checker = checker;
	}

	
}
