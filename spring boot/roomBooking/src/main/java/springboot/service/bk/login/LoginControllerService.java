package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.login.login.LoginReq;
import springboot.bean.vo.bk.login.login.LoginResp;
import springboot.trans.bk.login.vo.login.LoginReqTrans;
import springboot.trans.bk.login.vo.login.LoginRespTrans;
import util.ResponseUtil;

@Service("bk.login.LoginControllerService")
public class LoginControllerService {
	
	@Autowired
	@Qualifier("bk.login.LoginService")
	private LoginService loginService;
	
	
	@Autowired
	@Qualifier("bk.login.vo.login.LoginReqTrans")
	private LoginReqTrans loginReqTrans;
	@Autowired
	@Qualifier("bk.login.vo.login.LoginRespTrans")
	private LoginRespTrans loginRespTrans;
	
	

	public Response login(LoginReq loginReq) {
		
		LoginResp loginResp = loginRespTrans.dtoToVo(
				loginService.login(
						loginReqTrans.voToDto(loginReq)));
		
		return ResponseUtil.response200(loginResp);
	}
}
