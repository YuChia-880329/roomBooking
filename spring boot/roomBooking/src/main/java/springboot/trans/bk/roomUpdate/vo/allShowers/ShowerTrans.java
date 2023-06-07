package springboot.trans.bk.roomUpdate.vo.allShowers;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.allShowers.ShowerDto;
import springboot.bean.vo.bk.roomUpdate.allShowers.Shower;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.allShowers.ShowerTrans")
public class ShowerTrans implements VoWoTrans<Shower, ShowerDto> {

	@Override
	public Shower dtoToVoImpl(ShowerDto dto) {
		
		return Shower.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
