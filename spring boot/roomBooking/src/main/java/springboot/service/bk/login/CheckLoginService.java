package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.login.vo.wo.CheckLoginRespDto;
import springboot.bean.dto.bk.login.vo.wo.CheckLoginResultDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;

@Service
public class CheckLoginService {

	@Autowired
	private LoginStatusDao loginStatusDao;
	
	
	public CheckLoginRespDto checkLogin() {
		
		LoginDto login = loginStatusDao.getStatus();
		
		return CheckLoginRespDto.builder()
				.checkLoginResult(checkLogin(login))
				.build();
	}
	
	private CheckLoginResultDto checkLogin(LoginDto login) {
		
		return CheckLoginResultDto.builder()
				.login(login.isLogin())
				.build();
	}
}
