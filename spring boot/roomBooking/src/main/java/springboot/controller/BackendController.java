package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.bean.vo.Response;
import springboot.bean.vo.bk.hotelInfo.update.UpdateReq;
import springboot.bean.vo.bk.login.login.LoginReq;
import springboot.bean.vo.bk.roomCreate.create.CreateReq;
import springboot.service.bk.BkControllerService;
import springboot.service.bk.bookingOrderList.BookingOrderListControllerService;
import springboot.service.bk.hotelInfo.HotelInfoControllerService;
import springboot.service.bk.login.LoginControllerService;
import springboot.service.bk.roomCreate.RoomCreateControllerService;
import springboot.service.bk.roomList.RoomListControllerService;
import springboot.service.bk.roomUpdate.RoomUpdateControllerService;

@RestController
@CrossOrigin(origins = {"http://localhost:8086", "http://localhost:3000"}, allowCredentials = "true")
@RequestMapping("/backend")
public class BackendController {

	@Autowired
	@Qualifier("bk.BkControllerService")
	private BkControllerService bkControllerService;
	@Autowired
	@Qualifier("bk.login.LoginControllerService")
	private LoginControllerService loginService;
	@Autowired
	@Qualifier("bk.roomList.RoomListControllerService")
	private RoomListControllerService roomListService;
	@Autowired
	@Qualifier("bk.bookingOrderList.BookingOrderListControllerService")
	private BookingOrderListControllerService bookingOrderListService;
	@Autowired
	@Qualifier("bk.hotelInfo.HotelInfoControllerService")
	private HotelInfoControllerService hotelInfoService;
	@Autowired
	@Qualifier("bk.roomUpdate.RoomUpdateControllerService")
	private RoomUpdateControllerService roomUpdateService;
	@Autowired
	@Qualifier("bk.roomCreate.RoomCreateControllerService")
	private RoomCreateControllerService roomCreateService;
	
	
	
	@GetMapping("/checkLogin")
	public ResponseEntity<Response> checkLogin(){
		
		Response response = bkControllerService.checkLogin();
		return ResponseEntity.ok(response);
	}
	
	// login
	@PostMapping("/login/login")
	public ResponseEntity<Response> login(@RequestBody LoginReq loginReq) {
		
		Response response = loginService.login(loginReq);
		return ResponseEntity.ok(response);
	}

	// roomList
	@GetMapping("/roomList/searchTable")
	public ResponseEntity<Response> searchTableRoomList(@RequestParam(name = "name", required = false) String name, 
			@RequestParam(name = "totalNumMin", required = false) String totalNumMin, @RequestParam(name = "totalNumMax", required = false) String totalNumMax, 
			@RequestParam(name = "usedNumMin", required = false) String usedNumMin, @RequestParam(name = "usedNumMax", required = false) String usedNumMax, 
			@RequestParam(name = "invalidNumMin", required = false) String invalidNumMin, @RequestParam(name = "invalidNumMax", required = false) String invalidNumMax,
			@RequestParam(name = "priceMin", required = false) String priceMin, @RequestParam(name = "priceMax", required = false) String priceMax, 
			@RequestParam(name = "status", required = false) String status) {
		

		Response response = roomListService.searchTable(name, totalNumMin, totalNumMax, usedNumMin, usedNumMax, invalidNumMin, invalidNumMax, priceMin, priceMax, status);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/roomList/turnPage")
	public ResponseEntity<Response> turnPageRoomList(@RequestParam(name = "page") String page){
		
		Response response = roomListService.turnPage(page);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/roomList/changeOrder")
	public ResponseEntity<Response> changeOrderRoomList(@RequestParam(name = "order") String order){
		
		Response response = roomListService.changeOrder(order);
		return ResponseEntity.ok(response);
	}
	
	
	// bookingOrderList
	@GetMapping("/bookingOrderList/allRooms")
	public ResponseEntity<Response> allRoomsBookingOrderList(){
		
		Response response = bookingOrderListService.allRooms();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/bookingOrderList/allPayMethods")
	public ResponseEntity<Response> allPayMethods(){
		
		Response response = bookingOrderListService.allPayMethods();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/bookingOrderList/searchTable")
	public ResponseEntity<Response> searchTableBookingOrderList(@RequestParam(name = "idMin", required = false) String idMin, 
			@RequestParam(name = "idMax", required = false) String idMax, @RequestParam(name = "clientName", required = false) String clientName, 
			@RequestParam(name = "clientPhone", required = false) String clientPhone, @RequestParam(name = "roomType", required = false) String roomType, 
			@RequestParam(name = "roomNumMin", required = false) String roomNumMin, @RequestParam(name = "roomNumMax", required = false) String roomNumMax, 
			@RequestParam(name = "priceMin", required = false) String priceMin, @RequestParam(name = "priceMax", required = false) String priceMax, 
			@RequestParam(name = "payMethod", required = false) String[] payMethodIds, @RequestParam(name = "checkinDateTimeFrom", required = false) String checkinDateTimeFrom, 
			@RequestParam(name = "checkinDateTimeTo", required = false) String checkinDateTimeTo, @RequestParam(name = "checkoutDateFrom", required = false) String checkoutDateFrom, 
			@RequestParam(name = "checkoutDateTo", required = false) String checkoutDateTo, @RequestParam(name = "useDayMin", required = false) String useDayMin, 
			@RequestParam(name = "useDayMax", required = false) String useDayMax, @RequestParam(name = "totalPriceMin", required = false) String totalPriceMin, 
			@RequestParam(name = "totalPriceMax", required = false) String totalPriceMax) {
		

		Response response = bookingOrderListService.searchTable(idMin, idMax, clientName, clientPhone, roomType, roomNumMin, roomNumMax, priceMin, priceMax, 
				payMethodIds, checkinDateTimeFrom, checkinDateTimeTo, checkoutDateFrom, checkoutDateTo, useDayMin, useDayMax, totalPriceMin, totalPriceMax);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/bookingOrderList/turnPage")
	public ResponseEntity<Response> turnPageBookingOrderList(@RequestParam(name = "page") String page){
		
		Response response = bookingOrderListService.turnPage(page);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/bookingOrderList/changeOrder")
	public ResponseEntity<Response> changeOrderBookingOrderList(@RequestParam(name = "order") String order){
		
		Response response = bookingOrderListService.changeOrder(order);
		return ResponseEntity.ok(response);
	}
	
	
	// hotelInfo
	@GetMapping("/hotelInfo/allSections")
	public ResponseEntity<Response> allSections(){
		
		Response response = hotelInfoService.allSections();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/hotelInfo/allFeatures")
	public ResponseEntity<Response> allFeatures(){
		
		Response response = hotelInfoService.allFeatures();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/hotelInfo/allNewFeatures")
	public ResponseEntity<Response> allNewFeatures(){
		
		Response response = hotelInfoService.allNewFeatures();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/hotelInfo/checkNewFeature")
	public ResponseEntity<Response> checkNewFeature(@RequestParam(name = "name") String name){
		
		Response response = hotelInfoService.checkNewFeature(name);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/hotelInfo/hotelInfo")
	public ResponseEntity<Response> hotelInfo(){
		
		Response response = hotelInfoService.hotelInfo();
		return ResponseEntity.ok(response);
	}
	@PostMapping(value = "/hotelInfo/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> updateHotelInfo(@ModelAttribute UpdateReq updateReq){
		
		Response response = hotelInfoService.update(updateReq);
		return ResponseEntity.ok(response);
	}
	
	
	// roomUpdate
	@GetMapping("/roomUpdate/allShowers")
	public ResponseEntity<Response> allShowersRoomUpdate(){
		
		Response response = roomUpdateService.allShowers();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/roomUpdate/allScenes")
	public ResponseEntity<Response> allScenesRoomUpdate(){
		
		Response response = roomUpdateService.allScenes();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/roomUpdate/allRooms")
	public ResponseEntity<Response> allRoomsRoomUpdate(){
		
		Response response = roomUpdateService.allRooms();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/roomUpdate/roomInfo")
	public ResponseEntity<Response> roomInfo(@RequestParam(name = "roomId") int roomId){
		
		Response response = roomUpdateService.roomInfo(roomId);
		return ResponseEntity.ok(response);
	}
	@PostMapping(value = "/roomUpdate/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> updateRoomUpdate(@ModelAttribute springboot.bean.vo.bk.roomUpdate.update.UpdateReq updateReq){
		
		Response response = roomUpdateService.update(updateReq);
		return ResponseEntity.ok(response);
	}
	
	
	
	// roomCreate
	@GetMapping("/roomCreate/allShowers")
	public ResponseEntity<Response> allShowersRoomCreate(){
		
		Response response = roomCreateService.allShowers();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/roomCreate/allScenes")
	public ResponseEntity<Response> allScenesRoomCreate(){
		
		Response response = roomCreateService.allScenes();
		return ResponseEntity.ok(response);
	}
	@PostMapping(value = "/roomCreate/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> create(@ModelAttribute CreateReq createReq){
		
		Response response = roomCreateService.create(createReq);
		return ResponseEntity.ok(response);
	}
}
