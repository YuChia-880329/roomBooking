package springboot.service.bk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.vo.logout.LogoutRespDto;
import springboot.dao.bk.bookingOrderList.memory.repo.TablePagesRepoDao;
import springboot.dao.bk.login.memory.status.LoginStatusDao;

@Service("bk.LogoutService")
public class LogoutService {

	public static final String SUCCESS_MSG = "登出成功";
	public static final String FAILURE_MSG = "登出失敗";
	
	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("bk.bookingOrderList.memory.repo.TablePagesRepoDao")
	private TablePagesRepoDao tablePagesRepoDaoBookingOrderList;
	@Autowired
	@Qualifier("bk.roomList.memory.repo.TablePagesRepoDao")
	private springboot.dao.bk.roomList.memory.repo.TablePagesRepoDao tablePagesRepoDaoRoomList;
	
	
	public LogoutRespDto logout() {
		
		loginStatusDao.clearStatus();
		boolean success = true;
		
		if(success) {
			
			tablePagesRepoDaoBookingOrderList.needUpdate();
			tablePagesRepoDaoRoomList.needUpdate();
		}
		return LogoutRespDto.builder()
				.success(success)
				.msg(success ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
}
