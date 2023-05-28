package springboot.checker.bk.login.vo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.login.Form;
import springboot.bean.vo.bk.login.login.LoginReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.login.vo.login.LoginReqChecker")
public class LoginReqChecker implements Checker<LoginReq> {
	
	@Autowired
	@Qualifier("bk.login.vo.login.FormChecker")
	private FormChecker loginFormChecker;
	
	@Override
	public void check(LoginReq vo) throws RiCheckerException {
		
		checkVo(vo);
		
		checkLoginForm(vo);
	}

	public void checkVo(LoginReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	public void checkLoginForm(LoginReq vo) {
		
		Form form = vo.getForm();
		
		loginFormChecker.check(form);
	}
}
