package springboot.trans.bk.login.vo.login;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.login.ResultDto;
import springboot.bean.vo.bk.login.login.Result;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.login.vo.login.ResultTrans")
public class ResultTrans implements VoWoTrans<Result, ResultDto> {

	@Override
	public Result dtoToVoImpl(ResultDto dto) {
		
		return Result.builder()
				.result(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}
