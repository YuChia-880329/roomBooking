package springboot.checker.bk.login.vo.ri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.ri.LoginReq;
import springboot.bean.vo.bk.login.ri.LoginForm;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component
public class LoginReqChecker implements Checker<LoginReq> {
	
	@Autowired
	private LoginFormChecker loginFormChecker;
	
	@Override
	public void check(LoginReq vo) throws RiCheckerException {
		
		checkVO(vo);
		
		checkLoginForm(vo);
	}

	public void checkVO(LoginReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	public void checkLoginForm(LoginReq vo) {
		
		LoginForm loginForm = vo.getLoginForm();
		
		loginFormChecker.check(loginForm);
	}
}
