package springboot.trans.bk.roomCreate.vo.allShowers;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomCreate.vo.allShowers.ShowerDto;
import springboot.bean.vo.bk.roomCreate.allShowers.Shower;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomCreate.vo.allShowers.ShowerTrans")
public class ShowerTrans implements VoWoTrans<Shower, ShowerDto> {

	@Override
	public Shower dtoToVoImpl(ShowerDto dto) {
		
		return Shower.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
