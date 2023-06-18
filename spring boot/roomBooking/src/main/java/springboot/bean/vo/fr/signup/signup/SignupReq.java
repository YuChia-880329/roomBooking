package springboot.bean.vo.fr.signup.signup;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SignupReq {

	private String name;
	private String account;
	private String password;
	private String phone;
}
