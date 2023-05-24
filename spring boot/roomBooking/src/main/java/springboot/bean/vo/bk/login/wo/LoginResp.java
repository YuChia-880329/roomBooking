package springboot.bean.vo.bk.login.wo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.wo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LoginResp extends Data {

	private LoginResult loginResult;
}
