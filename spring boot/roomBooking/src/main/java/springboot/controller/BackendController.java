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

import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.RoomTableRowsDto;
import springboot.bean.vo.bk.login.ri.LoginReq;
import springboot.bean.vo.wo.Response;
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
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginReq loginReq) {
		
		Response response = loginService.login(loginReq);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/checkLogin")
	public ResponseEntity<Response> checkLogin(){
		
		Response response = loginService.checkLogin();
		return ResponseEntity.ok(response);
	}
	
	// roomList
	@GetMapping("/roomList/searchTable")
	public RoomTableRowsDto searchTable(@RequestParam(name = "page", required = false) String page, @RequestParam(name = "name", required = false) String name, 
			@RequestParam(name = "totalNumMin", required = false) String totalNumMin, @RequestParam(name = "totalNumMax", required = false) String totalNumMax, 
			@RequestParam(name = "usedNumMin", required = false) String usedNumMin, @RequestParam(name = "usedNumMax", required = false) String usedNumMax, 
			@RequestParam(name = "invalidNumMin", required = false) String invalidNumMin, @RequestParam(name = "invalidNumMax", required = false) String invalidNumMax,
			@RequestParam(name = "priceMin", required = false) String priceMin, @RequestParam(name = "priceMax", required = false) String priceMax, 
			@RequestParam(name = "order", required = false) String order) {
		
		
		return roomListService.searchTable(page, name, totalNumMin, totalNumMax, usedNumMin, usedNumMax, invalidNumMin, invalidNumMax, priceMin, priceMax, order);
	}
}
