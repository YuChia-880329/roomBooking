package springboot.checker.bk.login.vo.ri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.ri.Login;
import springboot.bean.vo.bk.login.ri.LoginForm;
import tmpl.checker.Checker;
import tmpl.exception.CheckerException;
import util.CheckUtil;

@Component
public class LoginChecker implements Checker<Login, CheckerException> {

	private static final String VO_PREFIX = "data";
	
	@Autowired
	private LoginFormChecker loginFormChecker;
	
	@Override
	public void check(Login vo) throws CheckerException {
		
		checkVO(vo);
		
		checkLoginForm(vo);
	}

	public void checkVO(Login vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, VO_PREFIX);
	}
	
	public void checkLoginForm(Login vo) throws CheckerException {
		
		LoginForm loginForm = vo.getLoginForm();
		
		loginFormChecker.check(loginForm);
	}
}
