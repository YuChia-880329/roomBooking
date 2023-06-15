package springboot.trans.fr.login.vo.login;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.login.vo.login.LoginRespDto;
import springboot.bean.vo.fr.login.login.LoginResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.login.vo.login.LoginRespTrans")
public class LoginRespTrans implements VoWoTrans<LoginResp, LoginRespDto> {

	@Override
	public LoginResp dtoToVoImpl(LoginRespDto dto) {
		
		return LoginResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}

}
