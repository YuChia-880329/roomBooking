package springboot.memory.status.bk;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.obj.bk.status.Login;
import springboot.memory.status.Status;

@Component
@SessionScope
public class LoginStatus extends Status<Login> {

	@Override
	protected Login ifNull() {
		
		return Login.builder()
				.isLogin(false)
				.build();
	}
}
