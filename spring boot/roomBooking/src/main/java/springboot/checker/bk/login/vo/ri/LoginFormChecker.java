package springboot.checker.bk.login.vo.ri;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.ri.LoginForm;
import tmpl.checker.Checker;
import tmpl.exception.CheckerException;
import util.CheckUtil;

@Component
public class LoginFormChecker implements Checker<LoginForm, CheckerException> {
	
	private static final String VO_PREFIX = "data, loginForm";

	@Override
	public void check(LoginForm vo) throws CheckerException {
		
		checkVO(vo);
		
		checkAccount(vo);
		checkPassword(vo);
	}

	public void checkVO(LoginForm vo) throws CheckerException {
		
		CheckUtil.checkOther(vo, VO_PREFIX);
	}
	
	public void checkAccount(LoginForm vo) {
	}
	public void checkPassword(LoginForm vo) {
	}
}
