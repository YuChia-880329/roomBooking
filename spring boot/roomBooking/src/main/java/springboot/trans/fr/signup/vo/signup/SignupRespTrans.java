package springboot.trans.fr.signup.vo.signup;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.vo.signup.signup.SignupRespDto;
import springboot.bean.vo.fr.signup.signup.SignupResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.signup.vo.signup.SignupRespTrans")
public class SignupRespTrans implements VoWoTrans<SignupResp, SignupRespDto> {

	@Override
	public SignupResp dtoToVoImpl(SignupRespDto dto) {
		
		return SignupResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}
