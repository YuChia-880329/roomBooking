package springboot.checker.fr.login.vo.login;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.login.login.LoginReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("fr.login.vo.login.LoginReqChecker")
public class LoginReqChecker implements Checker<LoginReq> {
	
	
	@Override
	public void check(LoginReq vo) throws RiCheckerException {
		
		checkVo(vo);
		
		checkAccount(vo);
		checkPassword(vo);
	}

	private void checkVo(LoginReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkAccount(LoginReq vo) {
		
		String account = vo.getAccount();
		
		CheckUtil.checkString(account);
	}
	private void checkPassword(LoginReq vo) {
		
		String password = vo.getPassword();
		
		CheckUtil.checkString(password);
	}
}
