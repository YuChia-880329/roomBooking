package springboot.trans.bk.login.obj.status.login;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.obj.bk.login.status.login.Login;
import springboot.memory.status.StatusTrans;

@Component("bk.login.obj.status.login.LoginTrans")
public class LoginTrans extends StatusTrans<Login, LoginDto> {

	@Override
	protected Login dtoToStatusImpl(LoginDto dto) {
		
		return Login.builder()
				.isLogin(dto.isLogin())
				.hotelId(dto.getHotelId())
				.build();
	}

	@Override
	protected LoginDto statusToDtoImpl(Login status) {
		
		return LoginDto.builder()
				.isLogin(status.isLogin())
				.hotelId(status.getHotelId())
				.build();
	}
}
