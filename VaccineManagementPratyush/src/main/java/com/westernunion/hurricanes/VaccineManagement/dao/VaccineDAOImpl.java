package com.westernunion.hurricanes.VaccineManagement.dao;

import java.sql.Date;
import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.westernunion.hurricanes.VaccineManagement.entity.Citizen;
import com.westernunion.hurricanes.VaccineManagement.entity.Vaccine;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class VaccineDAOImpl implements VaccineDAO {
	
	private EntityManager entityManager;
	
	public VaccineDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public Citizen registerCitizen(Citizen theCitizen) {
		// TODO Auto-generated method stub
		Session sessionObj = this.entityManager.unwrap(Session.class);
		sessionObj.saveOrUpdate(theCitizen);
		
		return theCitizen;
	}

	@Transactional
	public ArrayList<Citizen> getCitizenDetails() {
		// TODO Auto-generated method stub
		Session sessionObj = this.entityManager.unwrap(Session.class);
		Query queryObj = sessionObj.createQuery("from Citizen", Citizen.class);
		return (ArrayList<Citizen>) queryObj.getResultList();
	}
	
	@Transactional
	public Citizen getSingleCitizen(int citizen_id) {
		Session sessionObj = this.entityManager.unwrap(Session.class);
		Citizen citizen = sessionObj.get(Citizen.class, citizen_id);
		return citizen;
	}
	
	@Transactional
	public Vaccine getVaccineDetails(int citizen_id) {
		Session sessionObj = this.entityManager.unwrap(Session.class);
		Vaccine vaccineObj = sessionObj.get(Vaccine.class, citizen_id);
		return vaccineObj;
	}

	@Transactional
	public void firstDose(int id, String vaccineName, Date date) {
		// TODO Auto-generated method stub
		Session sessionObj = this.entityManager.unwrap(Session.class);
		Vaccine vaccineObj = new Vaccine(id, vaccineName, date, "First Dose");
		sessionObj.saveOrUpdate(vaccineObj);
	}
	
	@Transactional
	public void updateVaccinationDetails(Vaccine theVaccine) {
		Session sessionObj = this.entityManager.unwrap(Session.class);
		sessionObj.saveOrUpdate(theVaccine);
	}

	@Transactional
	public boolean deleteCitizen(int citizen_id) {
		// TODO Auto-generated method stub
		Session sessionObj = this.entityManager.unwrap(Session.class);
		Citizen citizen = this.getSingleCitizen(citizen_id);
		Vaccine vaccine = this.getVaccineDetails(citizen_id);
		if (vaccine.getBoosterDose() != null) {
			if (vaccine != null) sessionObj.remove(vaccine);
			if (citizen != null) sessionObj.remove(citizen);
			return true;
		}
		return false;
	}
}
