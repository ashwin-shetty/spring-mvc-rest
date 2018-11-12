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
	
	@PutMapping(value = "/customers",
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		System.out.println("Result : "+ customer.getFirstName());
		logger.info("This is method which returns JSON value");
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PutMapping(value = "/customers",
			consumes = {MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<Customer> createCustomerXML(@RequestBody Customer customer) {
				System.out.println("Result : "+ customer.getFirstName());
				logger.info("This is method which returns XML value");
				return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			}
	
	@PostMapping(value = "/customers",
			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
			public ResponseEntity<List<Customer>> customerDetails() {
				
				List cutomers = new ArrayList<Customer>();
				
				Customer customerFirst = new Customer();
				customerFirst = new Customer(); 
				customerFirst.setFirstName("Elvis");
				customerFirst.setLastName("Presley");
				cutomers.add(customerFirst);
				
				Customer customerSecond = new Customer();
				customerSecond.setFirstName("Michael");
				customerSecond.setLastName("Jackson");
				cutomers.add(customerSecond);
				
				//System.out.println("Result : "+ customer.getFirstName());
				logger.info("This is method which returns XML value");
				return new ResponseEntity<List<Customer>>(cutomers, HttpStatus.OK);
			}
}