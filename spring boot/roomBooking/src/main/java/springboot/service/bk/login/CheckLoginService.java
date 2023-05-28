package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.login.vo.checkLogin.CheckLoginRespDto;
import springboot.bean.dto.bk.login.vo.checkLogin.ResultDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;

@Service("bk.login.CheckLoginService")
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
		
		return ResultDto.builder()
				.login(login.isLogin())
				.build();
	}
}
