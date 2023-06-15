package springboot.service.fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.login.obj.status.login.LoginDto;
import springboot.bean.dto.fr.vo.checkLogin.CheckLoginRespDto;
import springboot.dao.fr.login.memory.status.LoginStatusDao;
import springboot.exception.NotLoginException;

@Service("fr.CheckLoginService")
public class CheckLoginService {

	@Autowired
	@Qualifier("fr.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	public CheckLoginRespDto checkLogin() {
		
		LoginDto login = loginStatusDao.getStatus();
		
		return checkLogin(login);
	}
	
	private CheckLoginRespDto checkLogin(LoginDto login) {
		
		boolean isLogin = login.isLogin();
		return CheckLoginRespDto.builder()
				.login(isLogin)
				.msg(isLogin ? "登入狀態" : NotLoginException.MSG)
				.build();
	}
}
