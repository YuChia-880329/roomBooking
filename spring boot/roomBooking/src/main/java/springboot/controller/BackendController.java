package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.bean.vo.bk.login.ri.LoginReq;
import springboot.bean.vo.wo.Response;
import springboot.service.bk.login.LoginControllerService;

@RestController
@CrossOrigin
@RequestMapping("/backend")
public class BackendController {

	@Autowired
	private LoginControllerService loginService;
	
	
	// login
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginReq loginReq) {
		
		Response response = loginService.login(loginReq);
		
		return ResponseEntity.ok(response);
	}
}
