package springboot.trans.fr.shoppingCart.vo.checkout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.checkout.CheckoutRespDto;
import springboot.bean.vo.fr.shoppingCart.checkout.CheckoutResp;
import springboot.bean.vo.fr.shoppingCart.checkout.ItemIndex;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.checkout.CheckoutRespTrans")
public class CheckoutRespTrans implements VoWoTrans<CheckoutResp, CheckoutRespDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.checkout.ItemIndexTrans")
	private ItemIndexTrans itemIndexTrans;
	
	
	@Override
	public CheckoutResp dtoToVoImpl(CheckoutRespDto dto) {
		
		return CheckoutResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.itemIndices(itemIndexTrans.dtoListToVoArray(dto.getItemIndices(), size -> new ItemIndex[size]))
				.build();
	}
}
