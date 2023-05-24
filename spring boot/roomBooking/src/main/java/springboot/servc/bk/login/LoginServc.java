package springboot.servc.bk.login;

import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.vo.ri.LoginFormDto;
import springboot.bean.dto.bk.login.vo.ri.LoginReqDto;
import springboot.bean.dto.bk.login.vo.wo.LoginRespDto;

@Service
public class LoginServc {

	
	
	public LoginRespDto login(LoginReqDto loginReq) {
		
		LoginFormDto loginFormDto = loginReq.getLoginForm();
		
		
	}
}
