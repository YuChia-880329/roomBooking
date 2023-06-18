package springboot.service.fr.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.bean.dto.fr.vo.signup.signup.SignupReqDto;
import springboot.bean.dto.fr.vo.signup.signup.SignupRespDto;
import springboot.bean.dto.model.MemberDto;
import springboot.dao.model.inner.MemberDaoInner;

@Service("fr.signup.SignupService")
public class SignupService {

	public static final String SUCCESS_MSG = "註冊成功";
	public static final String FAILURE_MSG = "註冊失敗";
	
	
	@Autowired
	@Qualifier("model.inner.MemberDaoInner")
	private MemberDaoInner memberDaoInner;
	
	
	@Transactional
	public SignupRespDto signup(SignupReqDto signupReq) {
		
		MemberDto member = MemberDto.builder()
				.id(0)
				.name(signupReq.getName())
				.account(signupReq.getAccount())
				.password(signupReq.getPassword())
				.phone(signupReq.getPhone())
				.build();
		
		member = memberDaoInner.save(member);
		boolean success = member!=null;
		
		return SignupRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
}
