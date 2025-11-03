package com.HMS_Apk.Hospital.Management.System.doclogin.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ValueGenerationType;

import com.HMS_Apk.Hospital.Management.System.entity.Doctor;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultations")
public class Consultation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "consultationId")
	private Long consultationId;
	
	@ManyToOne
	@JoinColumn(name = "patientId",nullable = false)
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "doctorid",nullable = false)
	private Doctor doctor;
	
	@OneToOne
	@JoinColumn(name = "appointmentId")
	private Appointment appointment;
	
	private LocalDate consultationDate;
	private String symptoms;
	private String diagnosis;
	private String treatment;
	private String notes;
	private LocalDate followUpDate;

	private String status;

//	----------------------------------------------------------

	public Consultation() {
		// TODO Auto-generated constructor stub
	}

	public Consultation(Long id, Patient patient, Doctor doctor, Appointment appointment, LocalDate consultationDate,
			String symptoms, String diagnosis, String treatment, String notes, LocalDate followUpDate, String status) {
		super();
		this.consultationId = id;
		this.patient = patient;
		this.doctor = doctor;
		this.appointment = appointment;
		this.consultationDate = consultationDate;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.notes = notes;
		this.followUpDate = followUpDate;
		this.status = status;
	}

	public Long getConsultationId() {
		return consultationId;
	}

	public void setConsultationId(Long id) {
		this.consultationId = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

	public LocalDate getConsultationDate() {
		return consultationDate;
	}

	public void setConsultationDate(LocalDate consultationDate) {
		this.consultationDate = consultationDate;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(LocalDate followUpDate) {
		this.followUpDate = followUpDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	----------------------------------------------------------

}