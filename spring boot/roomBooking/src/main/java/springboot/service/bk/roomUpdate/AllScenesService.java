package springboot.service.bk.roomUpdate;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.roomUpdate.vo.allScenes.AllScenesRespDto;
import springboot.bean.dto.bk.roomUpdate.vo.allScenes.SceneDto;
import springboot.dao.model.inner.SceneDaoInner;

@Service("bk.roomUpdate.AllScenesService")
public class AllScenesService {

	@Autowired
	@Qualifier("model.inner.SceneDaoInner")
	private SceneDaoInner sceneDaoInner;
	
	public AllScenesRespDto allScenes() {
		
		List<springboot.bean.dto.model.SceneDto> scenes = sceneDaoInner.findAllByOrderByIdAsc();
		return AllScenesRespDto.builder()
				.scenes(toScenesVo(scenes))
				.build();
	}
	
	private List<SceneDto> toScenesVo(List<springboot.bean.dto.model.SceneDto> scenes) {
		
		return scenes.stream()
				.map(scene -> toSceneVo(scene))
				.collect(Collectors.toList());
	}
	private SceneDto toSceneVo(springboot.bean.dto.model.SceneDto scene) {
		
		return SceneDto.builder()
				.id(scene.getId())
				.name(scene.getName())
				.build();
	}
}
