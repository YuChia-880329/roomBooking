package springboot.service.fr.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.signup.signup.SignupReq;
import springboot.trans.fr.signup.vo.signup.SignupReqTrans;
import springboot.trans.fr.signup.vo.signup.SignupRespTrans;
import util.ResponseUtil;

@Service("fr.signup.SignupControllerService")
public class SignupControllerService {

	@Autowired
	@Qualifier("fr.signup.SignupService")
	private SignupService signupService;
	
	@Autowired
	@Qualifier("fr.signup.vo.signup.SignupReqTrans")
	private SignupReqTrans signupReqTrans;
	@Autowired
	@Qualifier("fr.signup.vo.signup.SignupRespTrans")
	private SignupRespTrans signupRespTrans;
	
	
	public Response signup(SignupReq signupReq) {
		
		return ResponseUtil.response200(
				signupRespTrans.dtoToVo(
						signupService.signup(
								signupReqTrans.voToDto(signupReq))));
	}
}
