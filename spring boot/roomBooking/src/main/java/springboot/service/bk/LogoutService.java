package springboot.service.bk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.vo.logout.LogoutRespDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.service.MemoryClearService;

@Service("bk.LogoutService")
public class LogoutService {

	public static final String SUCCESS_MSG = "登出成功";
	public static final String FAILURE_MSG = "登出失敗";
	
	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("MemoryClearService")
	private MemoryClearService memoryClearService;
	
	
	public LogoutRespDto logout() {
		
		memoryClearService.clearBkBookingOrderListTablePagesRepo();
		memoryClearService.clearBkRoomListTablePagesRepo();
		
		loginStatusDao.clearStatus();
		boolean success = true;
		

		return LogoutRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
}
