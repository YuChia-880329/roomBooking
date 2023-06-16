package springboot.trans.fr.shoppingCart.vo.payMethodOptions;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.shoppingCart.vo.payMethodOptions.OptionDto;
import springboot.bean.vo.fr.shoppingCart.payMethodOptions.Option;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.shoppingCart.vo.payMethodOptions.OptionTrans")
public class OptionTrans implements VoWoTrans<Option, OptionDto> {

	@Override
	public Option dtoToVoImpl(OptionDto dto) {
		
		return Option.builder()
				.id(dto.getId())
				.name(dto.getName())
				.needCreditCard(dto.isNeedCreditCard())
				.build();
	}
}
