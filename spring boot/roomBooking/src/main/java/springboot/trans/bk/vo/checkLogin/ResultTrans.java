package springboot.trans.bk.vo.checkLogin;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.vo.checkLogin.ResultDto;
import springboot.bean.vo.bk.checkLogin.Result;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.vo.checkLogin.ResultTrans")
public class ResultTrans implements VoWoTrans<Result, ResultDto> {

	@Override
	public Result dtoToVoImpl(ResultDto dto) {
		
		return Result.builder()
				.login(dto.isLogin())
				.msg(dto.getMsg())
				.build();
	}
}
