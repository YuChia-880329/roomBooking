package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.SceneDto;
import springboot.bean.model.Scene;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component("model.inner.SceneTransInner")
public class SceneTransInner implements ModelRiTrans<Scene, SceneDto>, ModelWoTrans<Scene, SceneDto> {

	@Override
	public Scene dtoToModelImpl(SceneDto dto) {
		
		return Scene.builder()
				.id(dto.getId())
				.name(dto.getName())
				.rooms(null)
				.build();
	}

	@Override
	public SceneDto modelToDtoImpl(Scene model) {
		
		return SceneDto.builder()
				.id(model.getId())
				.name(model.getName())
				.rooms(null)
				.build();
	}

}
