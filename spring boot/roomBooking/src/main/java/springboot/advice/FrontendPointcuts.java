package springboot.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("FrontendPointcuts")
public class FrontendPointcuts {

	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.home.HomeControllerService.*(..))")
	public void homeControllerService() {}
	
	
	@Pointcut("homeControllerService()")
	public void controllerService() {}
}