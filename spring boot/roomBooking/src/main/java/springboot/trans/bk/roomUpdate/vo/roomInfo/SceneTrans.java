package springboot.trans.bk.roomUpdate.vo.roomInfo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.SceneDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.Scene;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.roomInfo.SceneTrans")
public class SceneTrans implements VoWoTrans<Scene, SceneDto> {

	@Override
	public Scene dtoToVoImpl(SceneDto dto) {
		
		return Scene.builder()
				.able(dto.isAble())
				.sceneId(dto.getSceneId())
				.build();
	}
}
