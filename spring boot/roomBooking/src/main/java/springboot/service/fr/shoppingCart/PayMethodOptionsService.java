package springboot.service.fr.shoppingCart;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.shoppingCart.vo.payMethodOptions.OptionDto;
import springboot.bean.dto.fr.shoppingCart.vo.payMethodOptions.PayMethodOptionsRespDto;
import springboot.bean.dto.model.PayMethodDto;
import springboot.dao.model.inner.PayMethodDaoInner;

@Service("fr.shoppingCart.PayMethodOptionsService")
public class PayMethodOptionsService {

	private static final String CREDIT_CARD_NAME = "信用卡";
	
	@Autowired
	@Qualifier("model.inner.PayMethodDaoInner")
	private PayMethodDaoInner payMethodDaoInner;
	
	
	public PayMethodOptionsRespDto payMethodOptions() {
		
		List<PayMethodDto> payMethods = payMethodDaoInner.queryAllPayMethods();
		
		return PayMethodOptionsRespDto.builder()
				.options(toOptionVos(payMethods))
				.build();
	}
	
	private List<OptionDto> toOptionVos(List<PayMethodDto> payMethods){
		
		return payMethods.stream()
				.map(payMethod -> toOptionVo(payMethod))
				.collect(Collectors.toList());
	}
	private OptionDto toOptionVo(PayMethodDto payMethod) {
		
		return OptionDto.builder()
				.id(payMethod.getId())
				.name(payMethod.getName())
				.needCreditCard(payMethod.getName().equals(CREDIT_CARD_NAME))
				.build();
	}
}
