package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.login.checkLogin.CheckLoginResp;
import springboot.bean.vo.bk.login.login.LoginReq;
import springboot.bean.vo.bk.login.login.LoginResp;
import springboot.trans.bk.login.vo.checkLogin.CheckLoginRespTrans;
import springboot.trans.bk.login.vo.login.LoginReqTrans;
import springboot.trans.bk.login.vo.login.LoginRespTrans;
import util.ResponseUtil;

@Service("bk.login.LoginControllerService")
public class LoginControllerService {
	
	@Autowired
	@Qualifier("bk.login.LoginService")
	private LoginService loginService;
	@Autowired
	@Qualifier("bk.login.CheckLoginService")
	private CheckLoginService checkLoginService;
	
	
	@Autowired
	@Qualifier("bk.login.vo.login.LoginReqTrans")
	private LoginReqTrans loginReqTrans;
	@Autowired
	@Qualifier("bk.login.vo.login.LoginRespTrans")
	private LoginRespTrans loginRespTrans;
	@Autowired
	@Qualifier("bk.login.vo.checkLogin.CheckLoginRespTrans")
	private CheckLoginRespTrans checkLoginRespTrans;
	
	

	public Response login(LoginReq loginReq) {
		
		LoginResp loginResp = loginRespTrans.dtoToVo(
				loginService.login(
						loginReqTrans.voToDto(loginReq)));
		
		return ResponseUtil.response200(loginResp);
	}
	
	public Response checkLogin() {
		
		CheckLoginResp checkLoginResp = checkLoginRespTrans.dtoToVo(
				checkLoginService.checkLogin());
		
		return ResponseUtil.response200(checkLoginResp);
	}
}
