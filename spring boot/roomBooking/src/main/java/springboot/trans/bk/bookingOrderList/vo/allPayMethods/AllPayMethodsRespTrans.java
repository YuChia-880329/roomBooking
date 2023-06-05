package springboot.trans.bk.bookingOrderList.vo.allPayMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.allPayMethods.AllPayMethodsRespDto;
import springboot.bean.vo.bk.bookingOrderList.allPayMethods.AllPayMethodsResp;
import springboot.bean.vo.bk.bookingOrderList.allPayMethods.PayMethod;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.bookingOrderList.vo.allPayMethods.AllPayMethodsRespTrans")
public class AllPayMethodsRespTrans implements VoWoTrans<AllPayMethodsResp, AllPayMethodsRespDto> {

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.allPayMethods.PayMethodTrans")
	private PayMethodTrans payMethodTrans;

	@Override
	public AllPayMethodsResp dtoToVoImpl(AllPayMethodsRespDto dto) {
		
		return AllPayMethodsResp.builder()
				.payMethods(payMethodTrans.dtoListToVoArray(dto.getPayMethods(), size -> new PayMethod[size]))
				.build();
	}
}
