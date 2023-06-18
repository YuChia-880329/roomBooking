package springboot.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("FrontendPointcuts")
public class FrontendPointcuts {

	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.FrControllerService.*(..))")
	public void frControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.login.LoginControllerService.*(..))")
	public void loginControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.signup.SignupControllerService.*(..))")
	public void signupControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.home.HomeControllerService.*(..))")
	public void homeControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.hotelPage.HotelPageControllerService.*(..))")
	public void hotelPageControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.shoppingCart.ShoppingCartControllerService.*(..))")
	public void shoppingCartControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.fr.receipt.ReceiptControllerService.*(..))")
	public void receiptControllerService() {}
	
	
	
	
	@Pointcut("frControllerService() || loginControllerService() || homeControllerService() || hotelPageControllerService() || "
			+ "shoppingCartControllerService() || receiptControllerService() || signupControllerService()")
	public void controllerService() {}
}
