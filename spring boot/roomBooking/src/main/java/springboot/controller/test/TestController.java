package springboot.controller.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.bean.model.Hotel;
import springboot.service.test.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/test")
	public List<Hotel> test(){
		
		return testService.findAllHotel();
	}
}
