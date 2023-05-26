package springboot.trans.bk.login.vo.wo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.wo.CheckLoginResultDto;
import springboot.bean.vo.bk.login.wo.CheckLoginResult;
import tmpl.trans.bean.vo.VoWoTrans;

@Component
public class CheckLoginResultTrans implements VoWoTrans<CheckLoginResult, CheckLoginResultDto> {

	@Override
	public CheckLoginResult dtoToVoImpl(CheckLoginResultDto dto) {
		
		return CheckLoginResult.builder()
				.login(dto.isLogin())
				.build();
	}
}
