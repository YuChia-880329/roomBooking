package springboot.trans.fr.hotelPage.vo.addShoppingCart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.addShoppingCart.AddShoppingCartReqDto;
import springboot.bean.vo.fr.hotelPage.addShoppingCart.AddShoppingCartReq;
import springboot.checker.fr.hotelPage.vo.addShoppingCart.AddShoppingCartReqChecker;
import springboot.trans.VoRiTransChecked;
import util.DateTimeUtil;

@Component("fr.hotelPage.vo.addShoppingCart.AddShoppingCartReqTrans")
public class AddShoppingCartReqTrans extends VoRiTransChecked<AddShoppingCartReq, AddShoppingCartReqDto, AddShoppingCartReqChecker> {

	@Override
	public AddShoppingCartReqDto voToDtoImpl(AddShoppingCartReq vo) {
		
		return AddShoppingCartReqDto.builder()
				.roomId(vo.getRoomId())
				.num(vo.getNum())
				.checkinTime(DateTimeUtil.toLocalTime(vo.getCheckinTime()))
				.build();
	}

	
	@Autowired
	@Qualifier("fr.hotelPage.vo.addShoppingCart.AddShoppingCartReqChecker")
	@Override
	public void setChecker(AddShoppingCartReqChecker checker) {
		
		this.checker = checker;
	}
}
