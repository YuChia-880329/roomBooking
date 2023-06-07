package springboot.bean.vo.bk.roomUpdate.allScenes;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllScenesResp extends Data {

	private Scene[] scenes;
}
