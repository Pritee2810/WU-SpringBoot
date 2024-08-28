package com.westernunion.hurricanes.VaccineManagement.controller;

import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.westernunion.hurricanes.VaccineManagement.dao.VaccineDAO;
import com.westernunion.hurricanes.VaccineManagement.entity.Citizen;
import com.westernunion.hurricanes.VaccineManagement.entity.Vaccine;

@RestController
@RequestMapping("/api")
public class VaccinationController {
	
	private VaccineDAO vaccineDAO;
	
	public VaccinationController(VaccineDAO vaccineDAO) {
		this.vaccineDAO = vaccineDAO;
	}
	
	@PostMapping("/register/{firstDose}/{vaccineName}/{date}")
	public Citizen registerCitizen(@PathVariable("firstDose") boolean firstDose, @PathVariable("vaccineName") String vaccineName, @PathVariable("date") Date date, @RequestBody Citizen theCitizen) {
		theCitizen.setId(0);
		Citizen registeredCitizen = vaccineDAO.registerCitizen(theCitizen);
		
		if (firstDose) {
			int id = registeredCitizen.getId();
			vaccineDAO.firstDose(id, vaccineName, date);
		}
		return theCitizen;
	}
	
	@GetMapping("/citizendetails")
	public ArrayList<Citizen> getCitizenDetails() {
		return this.vaccineDAO.getCitizenDetails();
	}
	
	@GetMapping("/singlecitizen/{citizen_id}")
	public Citizen getSingleCitizen(@PathVariable("citizen_id") int citizen_id) {
		return this.vaccineDAO.getSingleCitizen(citizen_id);
	}
	
	@GetMapping("/vaccination/status/{citizen_id}")
	public Vaccine getVaccineDetails(@PathVariable int citizen_id) {
		return this.vaccineDAO.getVaccineDetails(citizen_id);
	}
	
	@GetMapping("/firstdose/{id}/{vaccineName}/{date}")
	public String completeFirstDose(@PathVariable("id") int citizen_id, @PathVariable("vaccineName") String vaccineName, @PathVariable("date") Date date) {
		Vaccine vaccine = this.getVaccineDetails(citizen_id);
		if (vaccine != null) return "Citizen with id " + citizen_id + " has already completed their first dose";
		
		this.vaccineDAO.firstDose(citizen_id, vaccineName, date);
		
		return "First Dose Completed";
	}
	
	@GetMapping("/seconddose/{id}/{date}")
	public String secondDose(@PathVariable("id") int citizen_id, @PathVariable("date") Date date) {
		Vaccine vaccine = this.getVaccineDetails(citizen_id);
		Date firstDose = vaccine.getFirstDose();
		if (vaccine.getSecondDose() != null)return "Cannot complete second dose, the citizen with id " + citizen_id + "has already completed their second dose.";
		java.time.LocalDate fd = firstDose.toLocalDate();
		java.time.LocalDate sd = date.toLocalDate();
		long daysDiff = fd.atStartOfDay().until(sd.atStartOfDay(), ChronoUnit.DAYS);
		
		if ( daysDiff < 120) return "Cannot complete second dose, the citizen with id " + citizen_id + " is ineligible for second dose of vaccination.";
		vaccine.setSecondDose(date);
		vaccine.setStatus("Second Dose");
		this.vaccineDAO.updateVaccinationDetails(vaccine);
		return "Second Dose Completed";
	}
	
	@GetMapping("/boosterdose/{id}/{date}")
	public String boosterDose(@PathVariable("id") int citizen_id, @PathVariable("date") Date date) {
		Vaccine vaccine = this.getVaccineDetails(citizen_id);
		Date secondDose = vaccine.getSecondDose();
		if (vaccine.getBoosterDose() != null)return "Cannot complete second dose, the citizen with id " + citizen_id + " has already completed their booster dose.";
		java.time.LocalDate sd = secondDose.toLocalDate();
		java.time.LocalDate bd = date.toLocalDate();
		long daysDiff = sd.atStartOfDay().until(bd.atStartOfDay(), ChronoUnit.DAYS);
		
		if ( daysDiff < 120) return "Cannot complete second dose, the citizen with id " + citizen_id + " is ineligible for booster dose of vaccination.";
		vaccine.setBoosterDose(date);
		vaccine.setStatus("Booster Dose");
		this.vaccineDAO.updateVaccinationDetails(vaccine);
		return "Booster Dose Completed";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteDetails(@PathVariable("id") int citizen_id) {
		boolean del = this.vaccineDAO.deleteCitizen(citizen_id);
		if (del) return "Citizen info deleted.";
		
		return "Citizen with id: " + citizen_id + " cannot be deleted. Dose(s)pending.";
	}
}
