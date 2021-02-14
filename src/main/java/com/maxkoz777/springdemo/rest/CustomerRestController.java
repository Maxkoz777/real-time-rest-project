package com.maxkoz777.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	// get customer /w provided id

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {

		Customer customer = customerService.getCustomer(id);

		if (customer == null) {
			throw new CustomerNotFoundException("Customer id not found: " + id);
		}

		return customer;

	}

	// add new customer

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {

		customer.setId(0);

		customerService.saveCustomer(customer);

		return customer;

	}

	// update existing customer

	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {

		customerService.saveCustomer(customer);

		return customer;

	}
		
	
}


















