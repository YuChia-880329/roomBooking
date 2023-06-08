package springboot.bean.vo.bk.roomUpdate.update;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class UpdateResp extends Data {

	private boolean success;
	private String msg;
}
