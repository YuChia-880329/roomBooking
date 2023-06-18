package springboot.trans.fr.signup.vo.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.vo.signup.signup.SignupReqDto;
import springboot.bean.vo.fr.signup.signup.SignupReq;
import springboot.checker.fr.signup.vo.signup.SignupReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("fr.signup.vo.signup.SignupReqTrans")
public class SignupReqTrans extends VoRiTransChecked<SignupReq, SignupReqDto, SignupReqChecker> {

	@Override
	public SignupReqDto voToDtoImpl(SignupReq vo) {
		
		return SignupReqDto.builder()
				.name(vo.getName())
				.account(vo.getAccount())
				.password(vo.getPassword())
				.phone(vo.getPhone())
				.build();
	}

	@Autowired
	@Qualifier("fr.signup.vo.signup.SignupReqChecker")
	@Override
	public void setChecker(SignupReqChecker checker) {
		
		this.checker = checker;
	}
}
