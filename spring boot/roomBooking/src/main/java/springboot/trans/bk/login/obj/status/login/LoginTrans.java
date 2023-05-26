package springboot.trans.bk.login.obj.status.login;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.obj.bk.login.status.login.Login;
import springboot.memory.status.StatusTrans;

@Component
public class LoginTrans extends StatusTrans<Login, LoginDto> {

	@Override
	public LoginDto objToDtoImpl(Login obj) {
		
		return LoginDto.builder()
				.isLogin(obj.isLogin())
				.HotelId(obj.getHotelId())
				.build();
	}

	@Override
	public Login dtoToObjImpl(LoginDto dto) {
		
		return Login.builder()
				.isLogin(dto.isLogin())
				.HotelId(dto.getHotelId())
				.build();
	}
}
