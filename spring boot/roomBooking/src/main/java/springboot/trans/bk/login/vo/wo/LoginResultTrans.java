package springboot.trans.bk.login.vo.wo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.wo.LoginResultDto;
import springboot.bean.vo.bk.login.wo.LoginResult;
import tmpl.trans.bean.vo.VoWoTrans;

@Component
public class LoginResultTrans implements VoWoTrans<LoginResult, LoginResultDto> {

	@Override
	public LoginResult dtoToVoImpl(LoginResultDto dto) {
		
		return LoginResult.builder()
				.result(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}
