package springboot.trans.bk.login.vo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.login.vo.login.FormDto;
import springboot.bean.vo.bk.login.login.Form;
import springboot.checker.bk.login.vo.login.FormChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.login.vo.login.FormTrans")
public class FormTrans extends VoRiTransChecked<Form, FormDto, FormChecker> {

	@Override
	public FormDto voToDtoImpl(Form vo) {
		
		return FormDto.builder()
				.account(vo.getAccount())
				.password(vo.getPassword())
				.build();
	}

	@Autowired
	@Qualifier("bk.login.vo.login.FormChecker")
	@Override
	public void setChecker(FormChecker checker) {

		this.checker = checker;
	}
}
