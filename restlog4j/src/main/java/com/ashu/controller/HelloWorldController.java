package com.ashu.controller;



import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashu.model.Customer;

@RestController
@RequestMapping("/")
public class HelloWorldController {
	
	private static final Logger logger = LogManager
			.getLogger(HelloWorldController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String homepage()  {
		
	  return "<div><p> Set Header for Json Rest API</p> "
	  		+ "<p>Content-Type: application/json; charset=utf-8 </p> "
	  		+ "<p>Accept :  application/json; charset=utf-8 </p></div>";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld()  {	
	logger.info("Inside /test used to write check Log4j 2 Implementation");	
	  return "Hello World";
	}
	
	@PostMapping(value = "/post")
	@ResponseBody
	public String helloWorldPost()  {
		
	  return "Hello World";
	}
}