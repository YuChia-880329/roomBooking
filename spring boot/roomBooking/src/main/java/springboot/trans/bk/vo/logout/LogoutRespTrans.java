package springboot.trans.bk.vo.logout;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.vo.logout.LogoutRespDto;
import springboot.bean.vo.bk.logout.LogoutResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.vo.logout.LogoutRespTrans")
public class LogoutRespTrans implements VoWoTrans<LogoutResp, LogoutRespDto> {

	@Override
	public LogoutResp dtoToVoImpl(LogoutRespDto dto) {
		
		return LogoutResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}
