package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.SceneDto;
import springboot.bean.model.Scene;
import springboot.trans.model.inner.SceneTransInner;

@Component
public class SceneTrans extends ModelTrans<Scene, SceneDto> {

	@Autowired
	private SceneTransInner sceneTransInner;
	
	@Autowired
	private RoomTrans roomTrans;
	
	
	@Override
	Scene toModelRecrs(SceneDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, sceneTransInner::dtoToModel, cache::getSceneCache, cache::setSceneCache, model -> {
			
			model.setRooms(roomTrans.toModelRecrs(dto.getRooms(), cache));
		});
	}
	@Override
	SceneDto toDtoRecrs(Scene model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, sceneTransInner::modelToDto, cache::getSceneCache, cache::setSceneCache, dto -> {
			
			dto.setRooms(roomTrans.toDtoRecrs(model.getRooms(), cache));
		});
	}

}
