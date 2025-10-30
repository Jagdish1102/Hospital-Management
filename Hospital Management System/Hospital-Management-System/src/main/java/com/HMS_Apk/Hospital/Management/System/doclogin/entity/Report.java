package com.HMS_Apk.Hospital.Management.System.doclogin.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String reportType;     // e.g. "Blood Test", "X-Ray"
    private String description;    // e.g. "CBC with Differential"
    private String status;         // e.g. "Urgent", "Normal", "Pending Review"
    private LocalDateTime reportDate;
    
    
    
    
	public Report(Long id, String patientName, String reportType, String description, String status,
			LocalDateTime reportDate) {
		super();
		this.id = id;
		this.patientName = patientName;
		this.reportType = reportType;
		this.description = description;
		this.status = status;
		this.reportDate = reportDate;
	}
    
	public Report() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDateTime reportDate) {
		this.reportDate = reportDate;
	}
	
	
	
    

}
