package springboot.checker.bk.login.vo.ri;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.ri.LoginForm;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component
public class LoginFormChecker implements Checker<LoginForm> {

	@Override
	public void check(LoginForm vo) {
		
		checkVO(vo);
		
		checkAccount(vo);
		checkPassword(vo);
	}

	public void checkVO(LoginForm vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	public void checkAccount(LoginForm vo) {
	}
	public void checkPassword(LoginForm vo) {
	}
}
