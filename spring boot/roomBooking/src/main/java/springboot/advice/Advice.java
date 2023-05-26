package springboot.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import springboot.bean.vo.wo.Data;
import springboot.bean.vo.wo.Response;
import tmpl.checker.exception.CheckerException;
import util.LogsUtil;
import util.ResponseUtil;

@Aspect
@Component
public class Advice {
	
	private Logger errorLog = LogsUtil.getThrowableLog();

	@Around("springboot.advice.BackendPointcuts.controllerService()")
	public Response checkerExAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Response response;
		try {
			
			response = (Response)joinPoint.proceed();
			
		} catch(CheckerException ex) {
			
			response = ResponseUtil.response400(new Data() {}, ex.getMessage());
		} catch (Throwable ex) {
			
			errorLog.error(ex.getMessage(), ex);
			throw ex;
		}
		
		return response;
	}
}
