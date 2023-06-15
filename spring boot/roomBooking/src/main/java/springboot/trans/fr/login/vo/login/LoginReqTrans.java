package springboot.trans.fr.login.vo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.login.vo.login.LoginReqDto;
import springboot.bean.vo.fr.login.login.LoginReq;
import springboot.checker.fr.login.vo.login.LoginReqChecker;
import springboot.trans.VoRiTransChecked;
import springboot.trans.bk.login.vo.login.FormTrans;

@Component("fr.login.vo.login.LoginReqTrans")
public class LoginReqTrans extends VoRiTransChecked<LoginReq, LoginReqDto, LoginReqChecker> {

	@Autowired
	@Qualifier("bk.login.vo.login.FormTrans")
	private FormTrans formTrans;
	
	@Override
	public LoginReqDto voToDtoImpl(LoginReq vo) {
		
		return LoginReqDto.builder()
				.account(vo.getAccount())
				.password(vo.getPassword())
				.build();
	}

	@Autowired
	@Qualifier("fr.login.vo.login.LoginReqChecker")
	@Override
	public void setChecker(LoginReqChecker checker) {
		
		this.checker = checker;
	}
}
