package springboot.checker.bk.login.vo.ri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.ri.Login;
import springboot.bean.vo.bk.login.ri.LoginForm;
import tmpl.checker.Checker;
import tmpl.exception.RiCheckerException;
import util.CheckUtil;

@Component
public class LoginChecker implements Checker<Login, RiCheckerException> {

	private static final String VO_PREFIX = "登入資料";
	
	@Autowired
	private LoginFormChecker loginFormChecker;
	
	@Override
	public void check(Login vo) throws RiCheckerException {
		
		checkVO(vo);
		
		checkLoginForm(vo);
	}

	public void checkVO(Login vo) throws RiCheckerException {
		
		CheckUtil.checkOther(vo, VO_PREFIX);
	}
	
	public void checkLoginForm(Login vo) throws RiCheckerException {
		
		LoginForm loginForm = vo.getLoginForm();
		
		loginFormChecker.check(loginForm);
	}
}
