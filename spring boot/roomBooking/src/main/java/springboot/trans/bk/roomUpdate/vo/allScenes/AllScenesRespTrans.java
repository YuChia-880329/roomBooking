package springboot.trans.bk.roomUpdate.vo.allScenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.allScenes.AllScenesRespDto;
import springboot.bean.vo.bk.roomUpdate.allScenes.AllScenesResp;
import springboot.bean.vo.bk.roomUpdate.allScenes.Scene;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.allScenes.AllScenesRespTrans")
public class AllScenesRespTrans implements VoWoTrans<AllScenesResp, AllScenesRespDto> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.allScenes.SceneTrans")
	private SceneTrans sceneTrans;
	
	@Override
	public AllScenesResp dtoToVoImpl(AllScenesRespDto dto) {
		
		return AllScenesResp.builder()
				.scenes(sceneTrans.dtoListToVoArray(dto.getScenes(), size -> new Scene[size]))
				.build();
	}
}
