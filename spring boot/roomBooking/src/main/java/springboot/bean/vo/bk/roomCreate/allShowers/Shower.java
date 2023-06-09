package springboot.bean.vo.bk.roomCreate.allShowers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Shower {

	private int id;
	private String name;
}
