package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springboot.bean.vo.Response;
import springboot.bean.vo.bk.login.login.LoginReq;
import springboot.service.bk.login.LoginControllerService;
import springboot.service.bk.roomList.RoomListControllerService;

@RestController
@CrossOrigin(origins = {"http://localhost:8086", "http://localhost:3000"}, allowCredentials = "true")
@RequestMapping("/backend")
public class BackendController {

	@Autowired
	private LoginControllerService loginService;
	@Autowired
	private RoomListControllerService roomListService;
	
	
	// login
	@PostMapping("/login/login")
	public ResponseEntity<Response> login(@RequestBody LoginReq loginReq) {
		
		Response response = loginService.login(loginReq);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/login/checkLogin")
	public ResponseEntity<Response> checkLogin(){
		
		Response response = loginService.checkLogin();
		return ResponseEntity.ok(response);
	}
	
	// roomList
	@GetMapping("/roomList/searchTable")
	public ResponseEntity<Response> searchTable(@RequestParam(name = "name", required = false) String name, 
			@RequestParam(name = "totalNumMin", required = false) String totalNumMin, @RequestParam(name = "totalNumMax", required = false) String totalNumMax, 
			@RequestParam(name = "usedNumMin", required = false) String usedNumMin, @RequestParam(name = "usedNumMax", required = false) String usedNumMax, 
			@RequestParam(name = "invalidNumMin", required = false) String invalidNumMin, @RequestParam(name = "invalidNumMax", required = false) String invalidNumMax,
			@RequestParam(name = "priceMin", required = false) String priceMin, @RequestParam(name = "priceMax", required = false) String priceMax) {
		

		Response response = roomListService.searchTable(name, totalNumMin, totalNumMax, usedNumMin, usedNumMax, invalidNumMin, invalidNumMax, priceMin, priceMax);
		return ResponseEntity.ok(response);
	}
}
