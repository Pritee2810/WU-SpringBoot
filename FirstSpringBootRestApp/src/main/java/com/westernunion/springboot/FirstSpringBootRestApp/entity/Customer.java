package com.westernunion.springboot.FirstSpringBootRestApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity
@Table(name="Customer2")
@SequenceGenerator(name="mySequence", sequenceName="customer_sequence", initialValue=20, allocationSize=1)
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mySequence")
	@Column(name="CID")
	private int cId;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNNAME")
	private String lastName;
	@Column(name="EMAIL")
	private String eMail;
	
	public Customer() {
		
	}
	
	public Customer(int cId, String firstName, String lastName, String eMail) {
		super();
		this.cId = cId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}


	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	@Override
	public String toString() {
		return "Customer [cId=" + cId + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail
				+ "]";
	}

}
