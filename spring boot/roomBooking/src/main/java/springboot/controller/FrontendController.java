package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.hotelPage.addShoppingCart.AddShoppingCartReq;
import springboot.bean.vo.fr.login.login.LoginReq;
import springboot.bean.vo.fr.shoppingCart.checkout.CheckoutReq;
import springboot.bean.vo.fr.shoppingCart.delete.DeleteReq;
import springboot.bean.vo.fr.signup.signup.SignupReq;
import springboot.service.fr.FrControllerService;
import springboot.service.fr.home.HomeControllerService;
import springboot.service.fr.hotelPage.HotelPageControllerService;
import springboot.service.fr.login.LoginControllerService;
import springboot.service.fr.receipt.ReceiptControllerService;
import springboot.service.fr.shoppingCart.ShoppingCartControllerService;
import springboot.service.fr.signup.SignupControllerService;

@RestController
@CrossOrigin(origins = {"http://localhost:8086", "http://localhost:3000"}, allowCredentials = "true")
@RequestMapping("/frontend")
public class FrontendController {

	
	@Autowired
	@Qualifier("service.fr.FrControllerService")
	private FrControllerService frControllerService;
	@Autowired
	@Qualifier("fr.login.LoginControllerService")
	private LoginControllerService loginControllerService;
	@Autowired
	@Qualifier("fr.signup.SignupControllerService")
	private SignupControllerService signupControllerService;
	@Autowired
	@Qualifier("fr.home.HomeControllerService")
	private HomeControllerService homeControllerService;
	@Autowired
	@Qualifier("fr.hotelPage.HotelPageControllerService")
	private HotelPageControllerService hotelPageControllerService;
	@Autowired
	@Qualifier("fr.shoppingCart.ShoppingCartControllerService")
	private ShoppingCartControllerService shoppingCartControllerService;
	@Autowired
	@Qualifier("fr.receipt.ReceiptControllerService")
	private ReceiptControllerService receiptControllerService;
	
	
	
	@GetMapping("/checkLogin")
	public ResponseEntity<Response> checkLogin(){
		
		Response response = frControllerService.checkLogin();
		return ResponseEntity.ok(response);
	}
	@PostMapping("/logout")
	public ResponseEntity<Response> logout(){
		
		Response response = frControllerService.logout();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/searchHotel")
	public ResponseEntity<Response> searchHotel(@RequestParam(name = "name") String name){
		
		Response response = frControllerService.searchHotel(name);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/memberName")
	public ResponseEntity<Response> memberName(){
		
		Response response = frControllerService.memberName();
		return ResponseEntity.ok(response);
	}
	
	
	
	// login
	@PostMapping("/login/login")
	public ResponseEntity<Response> login(@RequestBody LoginReq loginReq){
		
		Response response = loginControllerService.login(loginReq);
		return ResponseEntity.ok(response);
	}
	
	
	// signup
	@PostMapping("/signup/signup")
	public ResponseEntity<Response> signup(@RequestBody SignupReq signupReq){
		
		Response response = signupControllerService.signup(signupReq);
		return ResponseEntity.ok(response);
	}
	
	
	// home
	@GetMapping("/home/allSections")
	public ResponseEntity<Response> allSections(){
		
		Response response = homeControllerService.allSections();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/home/search")
	public ResponseEntity<Response> searchHome(@RequestParam(name = "checkinDate") String checkinDate, 
			@RequestParam(name = "checkoutDate") String checkoutDate, @RequestParam(name = "numCode") String numCode, 
			@RequestParam(name = "sectionCode") String sectionCode){
		
		Response response = homeControllerService.search(checkinDate, checkoutDate, numCode, sectionCode);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/home/turnPage")
	public ResponseEntity<Response> turnPageHome(@RequestParam(name = "page") String page){
		
		Response response = homeControllerService.turnPage(page);
		return ResponseEntity.ok(response);
	}
	
	
	// hotelPage
	@GetMapping("/hotelPage/getInfo")
	public ResponseEntity<Response> getInfo(@RequestParam(name = "hotelId") String hotelId){
		
		Response response = hotelPageControllerService.getInfo(hotelId);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/hotelPage/search")
	public ResponseEntity<Response> searchHotelPage(@RequestParam(name = "hotelId") String hotelId, 
			@RequestParam(name = "checkinDate") String checkinDate, @RequestParam(name = "checkoutDate") String checkoutDate, 
			@RequestParam(name = "numCode") String numCode){
		
		Response response = hotelPageControllerService.search(hotelId, checkinDate, checkoutDate, numCode);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/hotelPage/turnPage")
	public ResponseEntity<Response> turnPageHotelPage(@RequestParam(name = "page") String page){
		
		Response response = hotelPageControllerService.turnPage(page);
		return ResponseEntity.ok(response);
	}
	@PostMapping("/hotelPage/addShoppingCart")
	public ResponseEntity<Response> addShoppingCart(@RequestBody AddShoppingCartReq addShoppingCartReq){
		
		Response response = hotelPageControllerService.addShoppingCart(addShoppingCartReq);
		return ResponseEntity.ok(response);
	}
	
	
	// shoppingCart
	@GetMapping("/shoppingCart/show")
	public ResponseEntity<Response> showShoppingCart(){
		
		Response response = shoppingCartControllerService.show();
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/shoppingCart/delete")
	public ResponseEntity<Response> delete(@RequestBody DeleteReq deleteReq){
		
		Response response = shoppingCartControllerService.delete(deleteReq);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/shoppingCart/payMethodOptions")
	public ResponseEntity<Response> payMethodOptions(){
		
		Response response = shoppingCartControllerService.payMethodOptions();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/shoppingCart/turnPage")
	public ResponseEntity<Response> turnPageShoppingCart(@RequestParam(name = "page") String page){
		
		Response response = shoppingCartControllerService.turnPage(page);
		return ResponseEntity.ok(response);
	}
	@PostMapping("/shoppingCart/checkout")
	public ResponseEntity<Response> checkout(@RequestBody CheckoutReq checkoutReq){
		
		Response response = shoppingCartControllerService.checkout(checkoutReq);
		return ResponseEntity.ok(response);
	}
	
	
	
	// receipt
	@GetMapping("/receipt/show")
	public ResponseEntity<Response> showReceipt(@RequestParam(name = "receiptId") String receiptId){
		
		Response response = receiptControllerService.show(receiptId);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/receipt/turnPage")
	public ResponseEntity<Response> turnPageReceipt(@RequestParam(name = "page") String page, @RequestParam(name = "receiptId") String receiptId){
		
		Response response = receiptControllerService.turnPage(page, receiptId);
		return ResponseEntity.ok(response);
	}
}
