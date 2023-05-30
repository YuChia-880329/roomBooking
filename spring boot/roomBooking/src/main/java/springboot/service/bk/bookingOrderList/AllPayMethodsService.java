package springboot.service.bk.bookingOrderList;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.bookingOrderList.vo.allPayMethods.AllPayMethodsRespDto;
import springboot.bean.dto.bk.bookingOrderList.vo.allPayMethods.PayMethodDto;
import springboot.dao.model.inner.PayMethodDaoInner;

@Service("bk.bookingOrderList.AllPayMethodsService")
public class AllPayMethodsService {
	
	@Autowired
	@Qualifier("model.inner.PayMethodDaoInner")
	private PayMethodDaoInner payMethodDaoInner;

	public AllPayMethodsRespDto allPayMethods() {
		
		List<springboot.bean.dto.model.PayMethodDto> payMethods = payMethodDaoInner.queryAllPayMethods();
	
		return AllPayMethodsRespDto.builder()
				.payMethods(toPayMethodsVo(payMethods))
				.build();
	}
	
	private List<PayMethodDto> toPayMethodsVo(List<springboot.bean.dto.model.PayMethodDto> payMethods){
		
		return payMethods.stream()
				.map(payMethod -> toPayMethodVo(payMethod))
				.collect(Collectors.toList());
	}
	private PayMethodDto toPayMethodVo(springboot.bean.dto.model.PayMethodDto payMethod) {
		
		return PayMethodDto.builder()
				.id(payMethod.getId())
				.name(payMethod.getName())
				.build();
	}
}
