package springboot.bean.vo.bk.logout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LogoutResp extends Data {

	private boolean success;
	private String msg;
}
