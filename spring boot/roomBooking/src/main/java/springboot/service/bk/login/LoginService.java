package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.vo.ri.LoginFormDto;
import springboot.bean.dto.bk.login.vo.ri.LoginReqDto;
import springboot.bean.dto.bk.login.vo.wo.LoginRespDto;
import springboot.bean.dto.bk.login.vo.wo.LoginResultDto;
import springboot.bean.dto.model.MemberDto;
import springboot.dao.model.inner.MemberDaoInner;

@Service
public class LoginService {
	
	private static final String SUCCESS_MSG = "登入成功";
	private static final String NO_ACCOUNT_MSG = "無此帳號";
	private static final String WRONG_PWD_MSG = "密碼錯誤";
	

	@Autowired
	private MemberDaoInner memberDaoInner;
	
	
	public LoginRespDto login(LoginReqDto loginReq) {
		
		LoginFormDto loginForm = loginReq.getLoginForm();
		MemberDto member = memberDaoInner.findFirstByAccount(loginForm.getAccount());
		
		return LoginRespDto.builder()
				.loginResult(login(loginForm, member))
				.build();
	}
	
	private LoginResultDto login(LoginFormDto loginForm, MemberDto member) {
		
		boolean success = true;
		String msg = SUCCESS_MSG;
		
		if(member == null) {
			
			success = false;
			msg = NO_ACCOUNT_MSG;
		}else if(!member.getPassword().equals(loginForm.getPassword())) {
			
			success = false;
			msg = WRONG_PWD_MSG;
		}
		
		return LoginResultDto.builder()
				.success(success)
				.msg(msg)
				.build();
	}
}
