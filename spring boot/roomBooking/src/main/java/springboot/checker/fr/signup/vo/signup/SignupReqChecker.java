package springboot.checker.fr.signup.vo.signup;

import org.springframework.stereotype.Component;

import springboot.bean.vo.fr.signup.signup.SignupReq;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("fr.signup.vo.signup.SignupReqChecker")
public class SignupReqChecker implements Checker<SignupReq> {

	@Override
	public void check(SignupReq vo) {
		
		checkVo(vo);
		
		checkName(vo);
		checkAccount(vo);
		checkPassword(vo);
		checkPhone(vo);
	}
	
	private void checkVo(SignupReq vo) {
		
		CheckUtil.checkOther(vo);
	}

	private void checkName(SignupReq vo) {
		
		String name = vo.getName();
		
		CheckUtil.checkString(name);
	}
	private void checkAccount(SignupReq vo) {
		
		String account = vo.getAccount();
		
		CheckUtil.checkString(account);
	}
	private void checkPassword(SignupReq vo) {
		
		String password = vo.getPassword();
		
		CheckUtil.checkString(password);
	}
	private void checkPhone(SignupReq vo) {
		
		String phone = vo.getPhone();
		
		CheckUtil.checkString(phone);
	}
}
