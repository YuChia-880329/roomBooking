package springboot.trans.fr.login.obj.status.login;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.login.obj.status.login.LoginDto;
import springboot.bean.obj.fr.login.status.login.Login;
import springboot.memory.status.StatusTrans;

@Component("fr.login.obj.status.login.LoginTrans")
public class LoginTrans extends StatusTrans<Login, LoginDto> {

	@Override
	protected Login dtoToStatusImpl(LoginDto dto) {
		
		return Login.builder()
				.isLogin(dto.isLogin())
				.memberId(dto.getMemberId())
				.build();
	}

	@Override
	protected LoginDto statusToDtoImpl(Login status) {
		
		return LoginDto.builder()
				.isLogin(status.isLogin())
				.memberId(status.getMemberId())
				.build();
	}
}
