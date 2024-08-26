package com.westernunion.springboot.FirstSpringBootRestApp.dao;

import java.util.ArrayList;

import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.westernunion.springboot.FirstSpringBootRestApp.entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class CustomerDaoImpl implements CustomerDAO{
	
	private EntityManager entityManager;
	public CustomerDaoImpl (EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	public ArrayList<Customer> getCustomer(){
		/*ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer c1=new Customer(56, "OOOO", "KKKK", "ok@gmail.com");
		Customer c2=new Customer(57, "ABC", "XYZ", "ax@gmail.com");
		Customer c3=new Customer(58, "hihi", "byebye", "hb@gmail.com");			//without database
		
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		
		return customers;
		*/
		
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("from Customer", Customer.class);   			//HQL (with database)
		
		ArrayList<Customer> customers=(ArrayList<Customer>) theQuery.getResultList();
		return customers;
		}

	public Customer getCustomers(int CID) {
		// TODO Auto-generated method st
		Session currentSession = entityManager.unwrap(Session.class);
		
		return currentSession.get(Customer.class, CID);
	}
	@Override
	@Transactional
	public void save(Customer theCustomer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCustomer);
	}
	
	@Transactional
	public void delete(int CID) {
		Session currentSession = entityManager.unwrap(Session.class);
		Customer theCustomer = currentSession.get(Customer.class, CID);
		currentSession.remove(theCustomer);
	}

	
}
