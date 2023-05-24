package springboot.controller.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.dto.model.HotelDto;
import springboot.bean.dto.model.HotelFeatureDto;
import springboot.bean.dto.model.MemberDto;
import springboot.bean.dto.model.PayMethodDto;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.dto.model.SceneDto;
import springboot.bean.dto.model.SectionDto;
import springboot.bean.dto.model.ShowerDto;
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
import springboot.trans.model.BookingOrderTrans;
import springboot.trans.model.HotelAccountTrans;
import springboot.trans.model.HotelFeatureTrans;
import springboot.trans.model.HotelTrans;
import springboot.trans.model.MemberTrans;
import springboot.trans.model.PayMethodTrans;
import springboot.trans.model.RoomImgTrans;
import springboot.trans.model.RoomTrans;
import springboot.trans.model.SceneTrans;
import springboot.trans.model.SectionTrans;
import springboot.trans.model.ShowerTrans;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	@Autowired
	private BookingOrderTrans bookingOrderTrans;
	@Autowired
	private HotelAccountTrans hotelAccountTrans;
	@Autowired
	private HotelTrans hotelTrans;
	@Autowired
	private HotelFeatureTrans hotelFeatureTrans;
	@Autowired
	private MemberTrans memberTrans;
	@Autowired
	private PayMethodTrans payMethodTrans;
	@Autowired
	private RoomTrans roomTrans;
	@Autowired
	private RoomImgTrans roomImgTrans;
	@Autowired
	private SceneTrans sceneTrans;
	@Autowired
	private SectionTrans sectionTrans;
	@Autowired
	private ShowerTrans showerTrans;
	
	
	@GetMapping("/testBookingOrder")
	public List<BookingOrderDto> testBookingOrder(){
		
		List<BookingOrder> list = testService.findAllBookingOrder();
		return bookingOrderTrans.modelListToDtoList(list);
	}
	@GetMapping("/testHotelAccount")
	public List<HotelAccountDto> testHotelAccount(){
		
		List<HotelAccount> list = testService.findAllHotelAccount();
		return hotelAccountTrans.modelListToDtoList(list);
	}
	@GetMapping("/testHotel")
	public List<HotelDto> testHotel(){
		
		List<Hotel> list = testService.findAllHotel();
		return hotelTrans.modelListToDtoList(list);
	}
	@GetMapping("/testHotelFeature")
	public List<HotelFeatureDto> testHotelFeature(){
		
		List<HotelFeature> list = testService.findAllHotelFeature();
		return hotelFeatureTrans.modelListToDtoList(list);
	}
	@GetMapping("/testMember")
	public List<MemberDto> testMember(){
		
		List<Member> list = testService.findAllMember();
		return memberTrans.modelListToDtoList(list);
	}
	@GetMapping("/testPayMethod")
	public List<PayMethodDto> testPayMethod(){
		
		List<PayMethod> list = testService.findAllPayMethod();
		return payMethodTrans.modelListToDtoList(list);
	}
	@GetMapping("/testRoom")
	public List<RoomDto> testRoom(){
		
		List<Room> list = testService.findAllRoom();
		return roomTrans.modelListToDtoList(list);
	}
	@GetMapping("/testRoomImg")
	public List<RoomImgDto> testRoomImg(){
		
		List<RoomImg> list = testService.findAllRoomImg();
		return roomImgTrans.modelListToDtoList(list);
	}
	@GetMapping("/testScene")
	public List<SceneDto> testScene(){
		
		List<Scene> list = testService.findAllScene();
		return sceneTrans.modelListToDtoList(list);
	}
	@GetMapping("/testSection")
	public List<SectionDto> testSection(){
		
		List<Section> list = testService.findAllSection();
		return sectionTrans.modelListToDtoList(list);
	}
	@GetMapping("/testShower")
	public List<ShowerDto> testShower(){
		
		List<Shower> list = testService.findAllShower();
		return showerTrans.modelListToDtoList(list);
	}
}
