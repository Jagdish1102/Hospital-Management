package com.HMS_Apk.Hospital.Management.System.doclogin.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

import com.HMS_Apk.Hospital.Management.System.entity.Patient;

@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicineName;
    private String dosage;
    private String instructions;
    private LocalDate dateIssued = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    public Prescription() {
		// TODO Auto-generated constructor stub
	}

	public Prescription(Long id, String medicineName, String dosage, String instructions, LocalDate dateIssued,
			Patient patient) {
		super();
		this.id = id;
		this.medicineName = medicineName;
		this.dosage = dosage;
		this.instructions = instructions;
		this.dateIssued = dateIssued;
		this.patient = patient;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public LocalDate getDateIssued() {
		return dateIssued;
	}

	public void setDateIssued(LocalDate dateIssued) {
		this.dateIssued = dateIssued;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
    
    
    
    
    
}