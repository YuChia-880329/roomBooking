package springboot.bean.dto.bk.roomCreate.vo.allScenes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SceneDto {

	private int id;
	private String name;
}
