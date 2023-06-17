package springboot.memory.status.fr.login;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.obj.fr.login.status.login.Login;
import springboot.memory.status.Status;

@Component("fr.login.LoginStatus")
@SessionScope
public class LoginStatus extends Status<Login> {

	
	@Override
	protected Login ifNull() {
		
		return Login.builder()
				.isLogin(false)
				.memberId(null)
				.build();
	}
}
