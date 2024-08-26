package com.westernunion.springboot.FirstSpringBootRestApp.dao;

import java.util.ArrayList;

import com.westernunion.springboot.FirstSpringBootRestApp.entity.Customer;

public interface CustomerDAO {

	ArrayList<Customer> getCustomer();

	Customer getCustomers(int CID);

	void save(Customer theCustomer);

	

	void delete(int CID);

}
