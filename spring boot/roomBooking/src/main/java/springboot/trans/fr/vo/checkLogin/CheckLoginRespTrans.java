package springboot.trans.fr.vo.checkLogin;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.vo.checkLogin.CheckLoginRespDto;
import springboot.bean.vo.fr.checkLogin.CheckLoginResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.vo.checkLogin.CheckLoginRespTrans")
public class CheckLoginRespTrans implements VoWoTrans<CheckLoginResp, CheckLoginRespDto> {

	
	@Override
	public CheckLoginResp dtoToVoImpl(CheckLoginRespDto dto) {
		
		return CheckLoginResp.builder()
				.login(dto.isLogin())
				.msg(dto.getMsg())
				.build();
	}

}
