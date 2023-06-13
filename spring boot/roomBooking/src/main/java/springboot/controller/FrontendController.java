package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.bean.vo.Response;
import springboot.service.fr.home.HomeControllerService;

@RestController
@CrossOrigin(origins = {"http://localhost:8086", "http://localhost:3000"}, allowCredentials = "true")
@RequestMapping("/frontend")
public class FrontendController {

	@Autowired
	@Qualifier("fr.home.HomeControllerService")
	private HomeControllerService homeControllerService;
	
	
	// home
	@GetMapping("/home/allSections")
	public ResponseEntity<Response> allSections(){
		
		Response response = homeControllerService.allSections();
		return ResponseEntity.ok(response);
	}
	@GetMapping("/home/search")
	public ResponseEntity<Response> search(@RequestParam(name = "checkinDate") String checkinDate, 
			@RequestParam(name = "checkoutDate") String checkoutDate, @RequestParam(name = "numCode") String numCode, 
			@RequestParam(name = "sectionCode") String sectionCode){
		
		Response response = homeControllerService.search(checkinDate, checkoutDate, numCode, sectionCode);
		return ResponseEntity.ok(response);
	}
}