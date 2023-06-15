package springboot.trans.fr.hotelPage.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.ShowerDto;
import springboot.bean.vo.fr.hotelPage.Shower;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.ShowerTrans")
public class ShowerTrans implements VoWoTrans<Shower, ShowerDto> {

	@Override
	public Shower dtoToVoImpl(ShowerDto dto) {
		
		return Shower.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
