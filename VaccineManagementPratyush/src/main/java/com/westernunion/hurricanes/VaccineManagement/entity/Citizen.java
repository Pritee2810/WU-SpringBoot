package com.westernunion.hurricanes.VaccineManagement.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Citizen")
@SequenceGenerator(name="myCitizenSequence", sequenceName="citizen_sequence",initialValue=20,allocationSize=1)
public class Citizen {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="myCitizenSequence")
	@Column(name="ID")
	private int id;
	
	@Column(name="AADHARNO")
	private String aadharNo;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="MIDDLENAME")
	private String middleName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="GENDER")
	private String gender;
	
	@Column(name="DATEOFBIRTH")
	private Date dateOfBirth;
	
	@Column(name="PHONENO")
	private String phoneNo;
	
	@Column(name="EMAIL")
	private String eMail;

	public Citizen(int id, String aadharNo, String firstName, String middleName, String lastName, String gender,
			Date dateOfBirth, String phoneNo, String eMail) {
		super();
		this.id = id;
		this.aadharNo = aadharNo;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phoneNo = phoneNo;
		this.eMail = eMail;
	}

	public Citizen() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "Citizen [id=" + id + ", aadharNo=" + aadharNo + ", firstName=" + firstName + ", middleName="
				+ middleName + ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", phoneNo=" + phoneNo + ", eMail=" + eMail + "]";
	}
	
	
}
