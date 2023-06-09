package springboot.bean.vo.bk.roomCreate.create;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CreateResp extends Data {

	private boolean success;
	private String msg;
}
