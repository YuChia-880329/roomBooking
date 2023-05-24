package springboot.trans.bk.login.vo.ri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.ri.LoginFormDto;
import springboot.bean.vo.bk.login.ri.LoginForm;
import springboot.checker.bk.login.vo.ri.LoginFormChecker;
import tmpl.trans.bean.vo.VoRiTransChecked;

@Component
public class LoginFormTrans implements VoRiTransChecked<LoginForm, LoginFormDto, LoginFormChecker> {

	@Autowired
	private LoginFormChecker checker;
	
	@Override
	public LoginFormDto voToDtoImpl(LoginForm vo) {
		
		return LoginFormDto.builder()
				.account(vo.getAccount())
				.password(vo.getPassword())
				.build();
	}

	@Override
	public LoginFormChecker getChecker() {
		
		return this.checker;
	}
}
