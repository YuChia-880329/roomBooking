package springboot.service.bk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.vo.checkLogin.CheckLoginRespDto;
import springboot.bean.dto.bk.vo.checkLogin.ResultDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.exception.NotLoginException;

@Service("bk.CheckLoginService")
public class CheckLoginService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	public CheckLoginRespDto checkLogin() {
		
		LoginDto login = loginStatusDao.getStatus();
		
		return CheckLoginRespDto.builder()
				.result(checkLogin(login))
				.build();
	}
	
	private ResultDto checkLogin(LoginDto login) {
		
		boolean isLogin = login.isLogin();
		return ResultDto.builder()
				.login(isLogin)
				.msg(isLogin ? "登入狀態" : NotLoginException.MSG)
				.build();
	}
}
