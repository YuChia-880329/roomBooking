package springboot.trans.bk.vo.checkLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.vo.checkLogin.CheckLoginRespDto;
import springboot.bean.vo.bk.checkLogin.CheckLoginResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.vo.checkLogin.CheckLoginRespTrans")
public class CheckLoginRespTrans implements VoWoTrans<CheckLoginResp, CheckLoginRespDto> {

	@Autowired
	@Qualifier("bk.vo.checkLogin.ResultTrans")
	private ResultTrans resultTrans;
	
	@Override
	public CheckLoginResp dtoToVoImpl(CheckLoginRespDto dto) {
		
		return CheckLoginResp.builder()
				.result(resultTrans.dtoToVo(dto.getResult()))
				.build();
	}

}
