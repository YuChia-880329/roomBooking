package springboot.trans.fr.shoppingCart.vo.checkout;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutRespDto;
import springboot.bean.vo.fr.shoppingCart.checkout.CheckoutResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.checkout.CheckoutRespTrans")
public class CheckoutRespTrans implements VoWoTrans<CheckoutResp, CheckoutRespDto> {
	
	@Override
	public CheckoutResp dtoToVoImpl(CheckoutRespDto dto) {
		
		return CheckoutResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.receiptRepoId(dto.getReceiptRepoId())
				.build();
	}
}
