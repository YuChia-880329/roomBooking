package springboot.trans.bk.login.vo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.login.LoginReqDto;
import springboot.bean.vo.bk.login.login.LoginReq;
import springboot.checker.bk.login.vo.login.LoginReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.login.vo.login.LoginReqTrans")
public class LoginReqTrans extends VoRiTransChecked<LoginReq, LoginReqDto, LoginReqChecker> {

	@Autowired
	@Qualifier("bk.login.vo.login.FormTrans")
	private FormTrans formTrans;
	
	@Override
	public LoginReqDto voToDtoImpl(LoginReq vo) {
		
		return LoginReqDto.builder()
				.form(formTrans.voToDto(vo.getForm()))
				.build();
	}

	@Autowired
	@Qualifier("bk.login.vo.login.LoginReqChecker")
	@Override
	public void setChecker(LoginReqChecker checker) {
		
		this.checker = checker;
	}
}
