package springboot.bean.vo.bk.login.wo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LoginResult {

	private boolean result;
	private String msg;
}
