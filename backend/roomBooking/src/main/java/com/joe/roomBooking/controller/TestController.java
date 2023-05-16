package com.joe.roomBooking.controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joe.roomBooking.bean.TestBean;

import util.LogsUtil;


@RestController
@CrossOrigin
public class TestController {

	private static final Logger LOG = LogsUtil.getLogger(TestController.class);
	private static final Logger THROWABLE_LOG = LogsUtil.getThrowableLog();
	
	
	@GetMapping("/t")
	public TestBean test() {
		
		return new TestBean("TestStr!!");
	}
}
