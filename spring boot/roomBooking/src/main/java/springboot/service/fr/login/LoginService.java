package springboot.service.fr.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.login.obj.status.login.LoginDto;
import springboot.bean.dto.fr.login.vo.login.LoginReqDto;
import springboot.bean.dto.fr.login.vo.login.LoginRespDto;
import springboot.bean.dto.model.MemberDto;
import springboot.dao.fr.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.MemberDaoInner;

@Service("fr.login.LoginService")
public class LoginService {

	private static final String SUCCESS_MSG = "登入成功";
	private static final String NO_ACCOUNT_MSG = "無此帳號";
	private static final String WRONG_PWD_MSG = "密碼錯誤";
	
	@Autowired
	@Qualifier("model.inner.MemberDaoInner")
	private MemberDaoInner memberDaoInner;
	@Autowired
	@Qualifier("fr.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	public LoginRespDto login(LoginReqDto loginReq) {
		
		MemberDto member = memberDaoInner.findFirstByAccount(loginReq.getAccount());
		
		return login(loginReq, member);
	}
	
	private LoginRespDto login(LoginReqDto loginReq, MemberDto member) {
		
		boolean success = true;
		String msg = SUCCESS_MSG;
		
		if(member == null) {
			
			success = false;
			msg = NO_ACCOUNT_MSG;
		}else if(!member.getPassword().equals(loginReq.getPassword())) {
			
			success = false;
			msg = WRONG_PWD_MSG;
		}
		
		loginStatusDao.setStatus(LoginDto.builder()
				.isLogin(success)
				.HotelId(member==null ? null : member.getId())
				.build());
		
		return LoginRespDto.builder()
				.success(success)
				.msg(msg)
				.build();
	}
}
