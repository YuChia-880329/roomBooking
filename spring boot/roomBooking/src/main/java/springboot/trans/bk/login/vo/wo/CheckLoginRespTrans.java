package springboot.trans.bk.login.vo.wo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.wo.CheckLoginRespDto;
import springboot.bean.vo.bk.login.wo.CheckLoginResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component
public class CheckLoginRespTrans implements VoWoTrans<CheckLoginResp, CheckLoginRespDto> {

	@Autowired
	private CheckLoginResultTrans checkLoginResultTrans;
	
	@Override
	public CheckLoginResp dtoToVoImpl(CheckLoginRespDto dto) {
		
		return CheckLoginResp.builder()
				.checkLoginResult(checkLoginResultTrans.dtoToVo(dto.getCheckLoginResult()))
				.build();
	}

}
