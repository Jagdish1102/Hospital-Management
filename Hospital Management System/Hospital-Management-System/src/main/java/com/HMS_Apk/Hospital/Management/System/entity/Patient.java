package com.HMS_Apk.Hospital.Management.System.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import org.hibernate.annotations.JoinColumnOrFormula;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private long patientId;

	@Column(name = "name")
	private String name;

	@Column(name = "medical_condition") // ✅ safe column name
	private String condition;

	@Column(name = "last_visit")
	@JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
	private LocalDateTime lastVisit;

	@Column(name = "email")
	private String email;

	@Column(name = "number")
	private String number;

	@Column(name = "status")
	private String status;

	@Column(name = "symtomps")
	private String symtomps;

	@Column(name = "age")
	private String age;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "prescription")
	private String prescription;

	@Column(name = "dose")
	private String dose;

	@Column(name = "fees")
	private String fees;

	@Column(name = "urgency")
	private String urgency;

	@Column(name = "address ")
	private String address;
	



	public Patient() {
	}

	public Patient(long id, String name, String condition, LocalDateTime lastVisit, String status, String age,
			String bloodGroup, String prescription, String email, String address, String number, String dose,
			String fees, String urgency, String symtomps) {
		super();
		this.patientId = id;
		this.name = name;
		this.condition = condition;
		this.lastVisit = lastVisit;
		this.status = status;
		this.age = age;
		this.bloodGroup = bloodGroup;
		this.prescription = prescription;
		this.dose = dose;
		this.fees = fees;
		this.urgency = urgency;
		this.symtomps = symtomps;
		this.email = email;
		this.number = number;
		this.address = address;
	}

	// --- Getters & Setters ---
	public long getPatientId() {
		return patientId;
	}

	public void setId(long id) {
		this.patientId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public LocalDateTime getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(LocalDateTime lastVisit) {
		this.lastVisit = lastVisit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAge() {
		return age;
	}

	public void setSymtomps(String symtomps) {
		this.symtomps = symtomps;
	}

	public String getSymtomps() {
		return symtomps;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
}
