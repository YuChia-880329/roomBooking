package springboot.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import springboot.bean.vo.Data;
import springboot.bean.vo.Response;
import springboot.exception.AppException;
import tmpl.checker.exception.CheckerException;
import util.LogsUtil;
import util.ResponseUtil;
import util.ThrowableUtil;

@Aspect
@Component("Advice")
public class Advice {
	
	private Logger log = LogsUtil.getLogger(Advice.class);
	private Logger errorLog = LogsUtil.getThrowableLog();

	@Around("springboot.advice.BackendPointcuts.controllerService()")
	public Response checkerExAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Response response;
		try {
			
			response = (Response)joinPoint.proceed();
			
		} catch(CheckerException | AppException ex) {
			
			response = ResponseUtil.response400(new Data() {}, ex.getMessage());
		} catch (Throwable ex) {
			
			CheckerException cex = ThrowableUtil.getNestedThrowable(ex, th -> th instanceof CheckerException);
			AppException aex = ThrowableUtil.getNestedThrowable(ex, th -> th instanceof AppException);
			
			
			if(cex != null) {
				
				response = ResponseUtil.response400(new Data() {}, cex.getMessage());
			}else if(aex != null) {
				
				response = ResponseUtil.response400(new Data() {}, aex.getMessage());
			}else {
				
				log.error(ex.getMessage(), ex);
				errorLog.error(ex.getMessage(), ex);
				response = ResponseUtil.response500(new Data() {});
			}
		}
		
		return response;
	}
}
