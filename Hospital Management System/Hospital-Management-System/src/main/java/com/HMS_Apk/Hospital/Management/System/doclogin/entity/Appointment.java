package com.HMS_Apk.Hospital.Management.System.doclogin.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointments")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointmentId")
	private long appointmentId;

	private String name;
	private String age;
	private String symtomps;
	private String number;
	 private String lastVisit;;
	private String status;
	private LocalDate date;
	private LocalTime time;

	public Appointment() {
		// TODO Auto-generated constructor stub
	}

	public Appointment(long id, String name, String age, String symtomps, String number, String lastVisit,
			LocalDate date, LocalTime time,String status) {
		super();
		this.appointmentId = id;
		this.name = name;
		this.age = age;
		this.symtomps = symtomps;
		this.number = number;
		this.lastVisit = lastVisit;
		this.date = date;
		this.time = time;
		this.status=status;
	}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long id) {
		this.appointmentId = id;
	}
	
	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSymtomps() {
		return symtomps;
	}

	public void setSymtomps(String symtomps) {
		this.symtomps = symtomps;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLastVisit() {
		return lastVisit;
	}

	public void setLastVisit(String lastVisit) {
		lastVisit = lastVisit;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	




}
