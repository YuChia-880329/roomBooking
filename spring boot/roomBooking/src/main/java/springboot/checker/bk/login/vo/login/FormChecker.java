package springboot.checker.bk.login.vo.login;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.login.login.Form;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.login.vo.login.FormChecker")
public class FormChecker implements Checker<Form> {

	@Override
	public void check(Form vo) {
		
		checkVo(vo);
		
		checkAccount(vo);
		checkPassword(vo);
	}

	public void checkVo(Form vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	public void checkAccount(Form vo) {
	}
	public void checkPassword(Form vo) {
	}
}
