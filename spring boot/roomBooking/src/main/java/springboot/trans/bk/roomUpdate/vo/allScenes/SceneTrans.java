package springboot.trans.bk.roomUpdate.vo.allScenes;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.allScenes.SceneDto;
import springboot.bean.vo.bk.roomUpdate.allScenes.Scene;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.allScenes.SceneTrans")
public class SceneTrans implements VoWoTrans<Scene, SceneDto> {

	@Override
	public Scene dtoToVoImpl(SceneDto dto) {
		
		return Scene.builder()
				.id(dto.getId())
				.name(dto.getName())
				.build();
	}
}
