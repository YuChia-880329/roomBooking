package springboot.bean.vo.bk.login.ri;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LoginForm {

	private String account;
	private String password;
}
