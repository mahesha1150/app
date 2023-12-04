package com.metakeep.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

	private Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
	
	@GetMapping("/helloworld")
	public String helloWorld(@RequestParam String userId) {
		/* logger.info("Hello World: "+ userId); */
		return "Hello World: "+ userId;
	}
}
