package springboot.service.fr.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.login.login.LoginReq;
import springboot.trans.fr.login.vo.login.LoginReqTrans;
import springboot.trans.fr.login.vo.login.LoginRespTrans;
import util.ResponseUtil;

@Service("fr.login.LoginControllerService")
public class LoginControllerService {

	@Autowired
	@Qualifier("fr.login.LoginService")
	private LoginService loginService;
	
	
	
	@Autowired
	@Qualifier("fr.login.vo.login.LoginReqTrans")
	private LoginReqTrans loginReqTrans;
	@Autowired
	@Qualifier("fr.login.vo.login.LoginRespTrans")
	private LoginRespTrans loginRespTrans;
	
	
	
	public Response login(LoginReq loginReq) {
		
		return ResponseUtil.response200(
				loginRespTrans.dtoToVo(
						loginService.login(
								loginReqTrans.voToDto(loginReq))));
	}
}
