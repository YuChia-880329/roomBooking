package springboot.trans.bk.roomCreate.vo.allScenes;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomCreate.vo.allScenes.SceneDto;
import springboot.bean.vo.bk.roomCreate.allScenes.Scene;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomCreate.vo.allScenes.SceneTrans")
public class SceneTrans implements VoWoTrans<Scene, SceneDto> {

	@Override
	public Scene dtoToVoImpl(SceneDto dto) {
		
		return Scene.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
