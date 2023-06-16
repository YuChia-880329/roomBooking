package springboot.service.fr.shoppingCart;

import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutRespDto;

@Service("fr.shoppingCart.CheckoutService")
public class CheckoutService {

	
	public CheckoutRespDto checkout() {
		
		return CheckoutRespDto.builder()
				.build();
	}
}
