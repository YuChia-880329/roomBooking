package springboot.memory.status.bk.login;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.obj.bk.login.status.login.Login;
import springboot.memory.status.Status;

@Component
@SessionScope
public class LoginStatus extends Status<Login> {

	public LoginStatus() {
		
		System.out.println("test");
	}
	@Override
	protected Login ifNull() {
		
		return Login.builder()
				.isLogin(false)
				.HotelId(null)
				.build();
	}
}
