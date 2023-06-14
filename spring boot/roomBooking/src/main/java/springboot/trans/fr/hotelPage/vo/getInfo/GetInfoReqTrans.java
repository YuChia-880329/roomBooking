package springboot.trans.fr.hotelPage.vo.getInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.getInfo.GetInfoReqDto;
import springboot.bean.vo.fr.hotelPage.getInfo.GetInfoReq;
import springboot.checker.fr.hotelPage.vo.getInfo.GetInfoReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.hotelPage.vo.getInfo.GetInfoReqTrans")
public class GetInfoReqTrans extends VoRiTransChecked<GetInfoReq, GetInfoReqDto, GetInfoReqChecker> {

	@Override
	public GetInfoReqDto voToDtoImpl(GetInfoReq vo) {
		
		return GetInfoReqDto.builder()
				.hotelId(Integer.parseInt(vo.getHotelId()))
				.build();
	}

	@Autowired
	@Qualifier("fr.hotelPage.vo.getInfo.GetInfoReqChecker")
	@Override
	public void setChecker(GetInfoReqChecker checker) {
		
		this.checker = checker;
	}
}
