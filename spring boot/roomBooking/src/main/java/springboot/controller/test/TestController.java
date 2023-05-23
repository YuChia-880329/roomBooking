package springboot.controller.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.bean.model.BookingOrder;
import springboot.bean.model.Hotel;
import springboot.bean.model.HotelAccount;
import springboot.bean.model.HotelFeature;
import springboot.bean.model.Member;
import springboot.bean.model.PayMethod;
import springboot.bean.model.Room;
import springboot.bean.model.RoomImg;
import springboot.bean.model.Scene;
import springboot.bean.model.Section;
import springboot.bean.model.Shower;
import springboot.service.test.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	
	@GetMapping("/testBookingOrder")
	public List<BookingOrder> testBookingOrder(){
		
		List<BookingOrder> bookingOrders = testService.findAllBookingOrder();
		return bookingOrders;
	}
	@GetMapping("/testHotelAccount")
	public List<HotelAccount> testHotelAccount(){
		
		return testService.findAllHotelAccount();
	}
	@GetMapping("/testHotel")
	public List<Hotel> testHotel(){
		
		return testService.findAllHotel();
	}
	@GetMapping("/testHotelFeature")
	public List<HotelFeature> testHotelFeature(){
		
		return testService.findAllHotelFeature();
	}
	@GetMapping("/testMember")
	public List<Member> testMember(){
		
		return testService.findAllMember();
	}
	@GetMapping("/testPayMethod")
	public List<PayMethod> testPayMethod(){
		
		return testService.findAllPayMethod();
	}
	@GetMapping("/testRoom")
	public List<Room> testRoom(){
		
		return testService.findAllRoom();
	}
	@GetMapping("/testRoomImg")
	public List<RoomImg> testRoomImg(){
		
		return testService.findAllRoomImg();
	}
	@GetMapping("/testScene")
	public List<Scene> testScene(){
		
		return testService.findAllScene();
	}
	@GetMapping("/testSection")
	public List<Section> testSection(){
		
		return testService.findAllSection();
	}
	@GetMapping("/testShower")
	public List<Shower> testShower(){
		
		return testService.findAllShower();
	}
}
