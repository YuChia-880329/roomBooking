package springboot.trans.bk.login.vo.wo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.wo.LoginRespDto;
import springboot.bean.vo.bk.login.wo.LoginResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component
public class LoginRespTrans implements VoWoTrans<LoginResp, LoginRespDto> {

	@Autowired
	private LoginResultTrans loginResultTrans;
	
	@Override
	public LoginResp dtoToVoImpl(LoginRespDto dto) {
		
		return LoginResp.builder()
				.loginResult(loginResultTrans.dtoToVo(dto.getLoginResult()))
				.build();
	}

}
