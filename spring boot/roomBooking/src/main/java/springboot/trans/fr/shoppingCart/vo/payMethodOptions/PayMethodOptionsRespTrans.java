package springboot.trans.fr.shoppingCart.vo.payMethodOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.payMethodOptions.PayMethodOptionsRespDto;
import springboot.bean.vo.fr.shoppingCart.payMethodOptions.Option;
import springboot.bean.vo.fr.shoppingCart.payMethodOptions.PayMethodOptionsResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.payMethodOptions.PayMethodOptionsRespTrans")
public class PayMethodOptionsRespTrans implements VoWoTrans<PayMethodOptionsResp, PayMethodOptionsRespDto> {

	@Autowired
	@Qualifier("fr.shoppingCart.vo.payMethodOptions.OptionTrans")
	private OptionTrans optionTrans;

	@Override
	public PayMethodOptionsResp dtoToVoImpl(PayMethodOptionsRespDto dto) {
		
		return PayMethodOptionsResp.builder()
				.options(optionTrans.dtoListToVoArray(dto.getOptions(), size -> new Option[size]))
				.build();
	}
}
