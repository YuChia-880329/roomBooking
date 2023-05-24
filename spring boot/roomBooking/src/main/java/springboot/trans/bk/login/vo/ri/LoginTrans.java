package springboot.trans.bk.login.vo.ri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.ri.LoginDto;
import springboot.bean.vo.bk.login.ri.Login;
import springboot.checker.bk.login.vo.ri.LoginChecker;
import tmpl.exception.CheckerException;
import tmpl.trans.bean.vo.VoRiTransChecked;

@Component
public class LoginTrans implements VoRiTransChecked<Login, LoginDto, CheckerException, LoginChecker> {

	@Autowired
	private LoginChecker checker;
	
	@Autowired
	private LoginFormTrans loginFormTrans;
	
	@Override
	public LoginDto voToDtoImpl(Login vo) throws CheckerException {
		
		return LoginDto.builder()
				.loginForm(loginFormTrans.voToDto(vo.getLoginForm()))
				.build();
	}

	@Override
	public LoginChecker getChecker() {
		
		return this.checker;
	}
}
