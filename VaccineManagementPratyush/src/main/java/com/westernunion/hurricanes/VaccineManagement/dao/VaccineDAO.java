package com.westernunion.hurricanes.VaccineManagement.dao;

import java.sql.Date;
import java.util.ArrayList;

import com.westernunion.hurricanes.VaccineManagement.entity.Citizen;
import com.westernunion.hurricanes.VaccineManagement.entity.Vaccine;

public interface VaccineDAO {

	Citizen registerCitizen(Citizen theCitizen);
	
	void firstDose(int id, String vaccineName, Date date);

	ArrayList<Citizen> getCitizenDetails();
	
	Citizen getSingleCitizen(int citizen_id);

	Vaccine getVaccineDetails(int citizen_id);

	void updateVaccinationDetails(Vaccine vaccine);

	boolean deleteCitizen(int citizen_id);

}
