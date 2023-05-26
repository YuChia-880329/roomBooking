package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.login.vo.ri.LoginFormDto;
import springboot.bean.dto.bk.login.vo.ri.LoginReqDto;
import springboot.bean.dto.bk.login.vo.wo.LoginRespDto;
import springboot.bean.dto.bk.login.vo.wo.LoginResultDto;
import springboot.bean.dto.model.HotelAccountDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.HotelAccountDaoInner;

@Service
public class LoginService {
	
	private static final String SUCCESS_MSG = "登入成功";
	private static final String NO_ACCOUNT_MSG = "無此帳號";
	private static final String WRONG_PWD_MSG = "密碼錯誤";
	

	@Autowired
	private HotelAccountDaoInner hotelAccountDaoInner;
	@Autowired
	private LoginStatusDao loginStatusDao;
	
	
	public LoginRespDto login(LoginReqDto loginReq) {
		
		LoginFormDto loginForm = loginReq.getLoginForm();
		HotelAccountDto hotelAccount = hotelAccountDaoInner.findFirstByAccount(loginForm.getAccount());
		
		return LoginRespDto.builder()
				.loginResult(login(loginForm, hotelAccount))
				.build();
	}
	
	private LoginResultDto login(LoginFormDto loginForm, HotelAccountDto hotelAccount) {
		
		boolean success = true;
		String msg = SUCCESS_MSG;
		
		if(hotelAccount == null) {
			
			success = false;
			msg = NO_ACCOUNT_MSG;
		}else if(!hotelAccount.getPassword().equals(loginForm.getPassword())) {
			
			success = false;
			msg = WRONG_PWD_MSG;
		}
		
		loginStatusDao.setStatus(LoginDto.builder()
				.isLogin(success)
				.HotelId(hotelAccount.getHotel().getId())
				.build());
		
		return LoginResultDto.builder()
				.success(success)
				.msg(msg)
				.build();
	}
}
