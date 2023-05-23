package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.SceneDto;
import springboot.bean.model.Scene;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class SceneTrans implements ModelRiTrans<Scene, SceneDto>, ModelWoTrans<Scene, SceneDto> {

	@Override
	public Scene dtoToModelImpl(SceneDto dto) {
		
		return null;
	}

	@Override
	public SceneDto modelToDtoImpl(Scene model) {
		
		return null;
	}

}
