package com.HMS_Apk.Hospital.Management.System.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctorid")
    private Long doctorid;

    private String name;
    private String specialization;
    private String qualification;
    private String phone;
    private String email;
    private int experienceYears;
    private String department;
    
    
//    ---------------------------------------------------
    public Doctor() {
		// TODO Auto-generated constructor stub
	}


public Doctor(Long id, String name, String specialization, String qualification, String phone, String email,
		int experienceYears, String department) {
	super();
	this.doctorid = id;
	this.name = name;
	this.specialization = specialization;
	this.qualification = qualification;
	this.phone = phone;
	this.email = email;
	this.experienceYears = experienceYears;
	this.department = department;
}


public Long getId() {
	return doctorid;
}


public void setId(Long id) {
	this.doctorid = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getSpecialization() {
	return specialization;
}


public void setSpecialization(String specialization) {
	this.specialization = specialization;
}


public String getQualification() {
	return qualification;
}


public void setQualification(String qualification) {
	this.qualification = qualification;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public int getExperienceYears() {
	return experienceYears;
}


public void setExperienceYears(int experienceYears) {
	this.experienceYears = experienceYears;
}


public String getDepartment() {
	return department;
}


public void setDepartment(String department) {
	this.department = department;
}


//--------------------------------------------------------------------------

}
