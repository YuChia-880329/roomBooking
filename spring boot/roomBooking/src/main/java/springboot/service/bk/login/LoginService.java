package springboot.service.bk.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.login.vo.login.FormDto;
import springboot.bean.dto.bk.login.vo.login.LoginReqDto;
import springboot.bean.dto.bk.login.vo.login.LoginRespDto;
import springboot.bean.dto.bk.login.vo.login.ResultDto;
import springboot.bean.dto.model.HotelAccountDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.HotelAccountDaoInner;

@Service("bk.login.LoginService")
public class LoginService {
	
	private static final String SUCCESS_MSG = "登入成功";
	private static final String NO_ACCOUNT_MSG = "無此帳號";
	private static final String WRONG_PWD_MSG = "密碼錯誤";
	

	@Autowired
	@Qualifier("model.inner.HotelAccountDaoInner")
	private HotelAccountDaoInner hotelAccountDaoInner;
	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	public LoginRespDto login(LoginReqDto loginReq) {
		
		FormDto loginForm = loginReq.getForm();
		HotelAccountDto hotelAccount = hotelAccountDaoInner.findFirstByAccount(loginForm.getAccount());
		
		return LoginRespDto.builder()
				.result(login(loginForm, hotelAccount))
				.build();
	}
	
	private ResultDto login(FormDto loginForm, HotelAccountDto hotelAccount) {
		
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
				.HotelId(hotelAccount==null ? null : hotelAccount.getHotel().getId())
				.build());
		
		return ResultDto.builder()
				.success(success)
				.msg(msg)
				.build();
	}
}
