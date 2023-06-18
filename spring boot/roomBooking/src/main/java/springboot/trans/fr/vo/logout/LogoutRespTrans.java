package springboot.trans.fr.vo.logout;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.vo.logout.LogoutRespDto;
import springboot.bean.vo.fr.logout.LogoutResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.vo.logout.LogoutRespTrans")
public class LogoutRespTrans implements VoWoTrans<LogoutResp, LogoutRespDto> {

	@Override
	public LogoutResp dtoToVoImpl(LogoutRespDto dto) {
		
		return LogoutResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}
