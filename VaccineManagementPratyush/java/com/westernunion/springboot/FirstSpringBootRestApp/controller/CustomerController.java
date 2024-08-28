package com.westernunion.springboot.FirstSpringBootRestApp.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.westernunion.springboot.FirstSpringBootRestApp.dao.CustomerDAO;
import com.westernunion.springboot.FirstSpringBootRestApp.entity.Customer;

@RestController
@RequestMapping("/api")

public class CustomerController {

public CustomerDAO customerDAO;
	
	public CustomerController(CustomerDAO thecustomer) {
		this.customerDAO = thecustomer;
	}
	
	@GetMapping("/customer")

	public ArrayList<Customer> getCustomer() {
		
		return customerDAO.getCustomer();
	}
	@GetMapping("/customer/{CID}")
	public Customer getCustomers(@PathVariable int CID) {
		
		Customer thecustomer = customerDAO.getCustomers(CID);
		if(thecustomer==null) {
			throw new CustomerNotFoundException("Customer not found "+CID);
		}
		
		return thecustomer;
	}
	@PostMapping("/customer")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
		theCustomer.setcId(0);
		customerDAO.save(theCustomer);
		return theCustomer;
	}
	@PutMapping("/customer/{CID}")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
		customerDAO.save(theCustomer);
		return theCustomer;
	}
	@DeleteMapping("/customer/{CID}")
	public int deleteCustomer(@PathVariable int CID ) {
		customerDAO.delete(CID);
		return  CID;
	}
}
