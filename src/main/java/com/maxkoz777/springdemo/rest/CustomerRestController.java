package com.maxkoz777.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxkoz777.springdemo.entity.Customer;
import com.maxkoz777.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	// autowire the CustomerService
	@Autowired
	private CustomerService customerService;
	
	// add mapping for GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {

		Customer customer = customerService.getCustomer(id);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + id);
		}

		return customer;

	}
		
	
}


















