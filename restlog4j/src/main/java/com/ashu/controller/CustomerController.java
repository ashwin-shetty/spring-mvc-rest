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
import org.springframework.web.bind.annotation.RestController;

import com.ashu.model.Customer;

@RestController
public class CustomerController {
	
	private static final Logger logger = LogManager
			.getLogger(CustomerController.class);
	public static List customers = new ArrayList<Customer>();
	
	static {
		Customer customerFirst = new Customer();
		customerFirst = new Customer(); 
		customerFirst.setFirstName("Elvis");
		customerFirst.setLastName("Presley");
		customers.add(customerFirst);
		
		Customer customerSecond = new Customer();
		customerSecond.setFirstName("Michael");
		customerSecond.setLastName("Jackson");
		customers.add(customerSecond);
	}

	@PutMapping(value = "/customers",
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		System.out.println("Result : "+ customer.getFirstName());
		logger.info("This is method which returns JSON value");
		customers.add(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PutMapping(value = "/customers",
			consumes = {MediaType.APPLICATION_XML_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE})
			public ResponseEntity<Customer> createCustomerXML(@RequestBody Customer customer) {
				System.out.println("Result : "+ customer.getFirstName());
				logger.info("This is method which returns XML value");
				customers.add(customer);
				return new ResponseEntity<Customer>(customer, HttpStatus.OK);
			}
	
	@PostMapping(value = "/customers",
			consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
			public ResponseEntity<List<Customer>> customerDetails() {
				
				//List cutomers = new ArrayList<Customer>();
		
				//System.out.println("Result : "+ customer.getFirstName());
				logger.info("This is method which returns XML value");
				return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
			}
}
