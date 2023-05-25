package springboot.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class Pointcuts {

	@Pointcut("execution(public springboot.bean.vo.wo.Response springboot.service.bk.login.LoginControllerService.*(..))")
	public void loginControllerService() {}
	
	

	@Pointcut("loginControllerService()")
	public void controllerService() {}
}
