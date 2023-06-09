package springboot.trans.bk.roomCreate.vo.allScenes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomCreate.vo.allScenes.AllScenesRespDto;
import springboot.bean.vo.bk.roomCreate.allScenes.AllScenesResp;
import springboot.bean.vo.bk.roomCreate.allScenes.Scene;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomCreate.vo.allScenes.AllScenesRespTrans")
public class AllScenesRespTrans implements VoWoTrans<AllScenesResp, AllScenesRespDto> {

	@Autowired
	@Qualifier("bk.roomCreate.vo.allScenes.SceneTrans")
	private SceneTrans sceneTrans;
	
	@Override
	public AllScenesResp dtoToVoImpl(AllScenesRespDto dto) {
		
		return AllScenesResp.builder()
				.scenes(sceneTrans.dtoListToVoArray(dto.getScenes(), size -> new Scene[size]))
				.build();
	}
}
