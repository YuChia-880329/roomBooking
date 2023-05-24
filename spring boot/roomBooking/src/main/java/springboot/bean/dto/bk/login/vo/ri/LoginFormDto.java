package springboot.bean.dto.bk.login.vo.ri;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LoginFormDto {

	private String account;
	private String password;
}
