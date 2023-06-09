package springboot.bean.vo.bk.roomCreate.allScenes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Scene {

	private int id;
	private String name;
}
