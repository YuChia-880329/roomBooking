package com.joe.roomBooking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.roomBooking.bean.TestBean;


@RestController
public class TestController {

	@GetMapping("/t")
	public TestBean test() {
		
		return new TestBean("test");
	}
}
