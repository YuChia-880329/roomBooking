package springboot.trans.bk.login.vo.ri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.ri.LoginReqDto;
import springboot.bean.vo.bk.login.ri.LoginReq;
import springboot.checker.bk.login.vo.ri.LoginReqChecker;
import springboot.trans.VoRiTransChecked;

@Component
public class LoginReqTrans extends VoRiTransChecked<LoginReq, LoginReqDto, LoginReqChecker> {

	@Autowired
	private LoginFormTrans loginFormTrans;
	
	@Override
	public LoginReqDto voToDtoImpl(LoginReq vo) {
		
		return LoginReqDto.builder()
				.loginForm(loginFormTrans.voToDto(vo.getLoginForm()))
				.build();
	}

	@Autowired
	@Override
	public void setChecker(LoginReqChecker checker) {
		
		this.checker = checker;
	}
}
