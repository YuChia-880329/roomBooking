package springboot.bean.dto.bk.roomUpdate.vo.allScenes;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllScenesRespDto {

	private List<SceneDto> scenes;
}
