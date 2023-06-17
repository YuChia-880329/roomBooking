package springboot.bean.obj.bk.login.status.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Login {

	private boolean isLogin;
	private Integer hotelId;
}
