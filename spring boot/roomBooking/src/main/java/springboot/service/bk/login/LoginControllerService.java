package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.vo.bk.login.ri.LoginReq;
import springboot.bean.vo.bk.login.wo.LoginResp;
import springboot.bean.vo.wo.Response;
import springboot.trans.bk.login.vo.ri.LoginReqTrans;
import springboot.trans.bk.login.vo.wo.LoginRespTrans;
import util.ResponseUtil;

@Service
public class LoginControllerService {
	
	@Autowired
	private LoginService loginService;
	
	
	@Autowired
	private LoginReqTrans loginReqTrans;
	@Autowired
	private LoginRespTrans loginRespTrans;
	
	

	public Response login(LoginReq loginReq) {
		
		LoginResp loginResp = loginRespTrans.dtoToVo(
				loginService.login(
						loginReqTrans.voToDto(loginReq)));
		
		return ResponseUtil.response200(loginResp);
	}
}
