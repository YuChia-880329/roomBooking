package springboot.trans.bk.roomUpdate.vo.allShowers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.allShowers.AllShowersRespDto;
import springboot.bean.vo.bk.roomUpdate.allShowers.AllShowersResp;
import springboot.bean.vo.bk.roomUpdate.allShowers.Shower;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.allShowers.AllShowersRespTrans")
public class AllShowersRespTrans implements VoWoTrans<AllShowersResp, AllShowersRespDto> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.allShowers.ShowerTrans")
	private ShowerTrans showerTrans;
	
	@Override
	public AllShowersResp dtoToVoImpl(AllShowersRespDto dto) {
		
		return AllShowersResp.builder()
				.showers(showerTrans.dtoListToVoArray(dto.getShowers(), size -> new Shower[size]))
				.build();
	}
}
