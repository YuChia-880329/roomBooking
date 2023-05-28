package springboot.trans.bk.login.vo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.login.LoginRespDto;
import springboot.bean.vo.bk.login.login.LoginResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.login.vo.login.LoginRespTrans")
public class LoginRespTrans implements VoWoTrans<LoginResp, LoginRespDto> {

	@Autowired
	@Qualifier("bk.login.vo.login.ResultTrans")
	private ResultTrans resultTrans;
	
	@Override
	public LoginResp dtoToVoImpl(LoginRespDto dto) {
		
		return LoginResp.builder()
				.result(resultTrans.dtoToVo(dto.getResult()))
				.build();
	}

}
