package springboot.trans.bk.login.vo.checkLogin;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.checkLogin.ResultDto;
import springboot.bean.vo.bk.login.checkLogin.Result;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.login.vo.checkLogin.ResultTrans")
public class ResultTrans implements VoWoTrans<Result, ResultDto> {

	@Override
	public Result dtoToVoImpl(ResultDto dto) {
		
		return Result.builder()
				.login(dto.isLogin())
				.build();
	}
}
