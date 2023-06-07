package springboot.advice;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component("BackendPointcuts")
public class BackendPointcuts {

	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.BkControllerService.*(..))")
	public void bkControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.login.LoginControllerService.*(..))")
	public void loginControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.roomList.RoomListControllerService.*(..))")
	public void roomListControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.bookingOrderList.BookingOrderListControllerService.*(..))")
	public void bookingOrderListControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.hotelInfo.HotelInfoControllerService.*(..))")
	public void hotelInfoControllerService() {}
	
	@Pointcut("execution(public springboot.bean.vo.Response springboot.service.bk.roomUpdate.RoomUpdateControllerService.*(..))")
	public void roomUpdateControllerService() {}
	
	

	@Pointcut("bkControllerService() || loginControllerService() || roomListControllerService() || "
			+ "bookingOrderListControllerService() || hotelInfoControllerService() || roomUpdateControllerService()")
	public void controllerService() {}
}
