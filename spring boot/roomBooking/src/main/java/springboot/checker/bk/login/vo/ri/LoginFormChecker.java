package springboot.checker.bk.login.vo.ri;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.ri.LoginForm;
import tmpl.checker.Checker;
import tmpl.exception.RiCheckerException;
import util.CheckUtil;

@Component
public class LoginFormChecker implements Checker<LoginForm, RiCheckerException> {
	
	private static final String VO_PREFIX = "登入表單";

	@Override
	public void check(LoginForm vo) throws RiCheckerException {
		
		checkVO(vo);
		
		checkAccount(vo);
		checkPassword(vo);
	}

	public void checkVO(LoginForm vo) throws RiCheckerException {
		
		CheckUtil.checkOther(vo, VO_PREFIX);
	}
	
	public void checkAccount(LoginForm vo) {
	}
	public void checkPassword(LoginForm vo) {
	}
}
