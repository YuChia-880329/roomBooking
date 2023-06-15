package springboot.trans.fr.hotelPage.vo.addShoppingCart;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.addShoppingCart.AddShoppingCartRespDto;
import springboot.bean.vo.fr.hotelPage.addShoppingCart.AddShoppingCartResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.addShoppingCart.AddShoppingCartRespTrans")
public class AddShoppingCartRespTrans implements VoWoTrans<AddShoppingCartResp, AddShoppingCartRespDto> {

	@Override
	public AddShoppingCartResp dtoToVoImpl(AddShoppingCartRespDto dto) {
		
		return AddShoppingCartResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}
