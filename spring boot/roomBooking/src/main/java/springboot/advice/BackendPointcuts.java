package springboot.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("BackendPointcuts")
public class BackendPointcuts {

	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.login.LoginControllerService.*(..))")
	public void loginControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.roomList.RoomListControllerService.*(..))")
	public void roomListControllerService() {}
	
	

	@Pointcut("loginControllerService() || roomListControllerService()")
	public void controllerService() {}
}
