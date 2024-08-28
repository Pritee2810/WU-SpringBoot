package com.westernunion.hurricanes.VaccineManagement.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Vaccine")
public class Vaccine {
	@Id
	@Column(name="CITIZEN_ID")
	private int citizen_id;
	
	@Column(name="VACCINENAME")
	private String vaccineName;
	
	@Column(name="FIRSTDOSE")
	private Date firstDose;
	
	@Column(name="SECONDDOSE")
	private Date secondDose;
	
	@Column(name="BOOSTERDOSE")
	private Date boosterDose;
	
	@Column(name="STATUS")
	private String status;

	public Vaccine(int citizen_id, String vaccineName, Date firstDose, Date secondDose, Date boosterDose,
			String status) {
		super();
		this.citizen_id = citizen_id;
		this.vaccineName = vaccineName;
		this.firstDose = firstDose;
		this.secondDose = secondDose;
		this.boosterDose = boosterDose;
		this.status = status;
	}

	public Vaccine() {
		super();
	}
	
	public Vaccine(int citizen_id, String vaccineName, Date firstDose, String status) {
		this.citizen_id = citizen_id;
		this.vaccineName = vaccineName;
		this.firstDose = firstDose;
		this.status = status;
	}

	public int getCitizen_id() {
		return citizen_id;
	}

	public void setCitizen_id(int citizen_id) {
		this.citizen_id = citizen_id;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Date getFirstDose() {
		return firstDose;
	}

	public void setFirstDose(Date firstDose) {
		this.firstDose = firstDose;
	}

	public Date getSecondDose() {
		return secondDose;
	}

	public void setSecondDose(Date secondDose) {
		this.secondDose = secondDose;
	}

	public Date getBoosterDose() {
		return boosterDose;
	}

	public void setBoosterDose(Date boosterDose) {
		this.boosterDose = boosterDose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Vaccine [citizen_id=" + citizen_id + ", vaccineName=" + vaccineName + ", firstDose=" + firstDose
				+ ", secondDose=" + secondDose + ", boosterDose=" + boosterDose + ", status=" + status + "]";
	}

	
}
