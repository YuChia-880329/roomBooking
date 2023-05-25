package springboot.trans.bk.memory.status;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.obj.status.LoginDto;
import springboot.bean.obj.bk.status.Login;
import springboot.memory.status.StatusTrans;

@Component
public class LoginTrans extends StatusTrans<Login, LoginDto> {

	@Override
	public LoginDto objToDtoImpl(Login obj) {
		
		return LoginDto.builder()
				.isLogin(obj.isLogin())
				.build();
	}

	@Override
	public Login dtoToObjImpl(LoginDto dto) {
		
		return Login.builder()
				.isLogin(dto.isLogin())
				.build();
	}
}
