package com.HMS_Apk.Hospital.Management.System.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS_Apk.Hospital.Management.System.Repository.PatientRepository;
import com.HMS_Apk.Hospital.Management.System.entity.Doctor;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
	
	 PatientRepository patientRepository;

	public PatientController(PatientRepository paientRepository) {
		super();
		this.patientRepository = paientRepository;
	}
	@PostMapping("/insert")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);
		
		
	}
	
	@GetMapping
	public List<Patient> getAllPatient(){
		return patientRepository.findAll();
	}
	
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<Map<String,Boolean>>deletePatient(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With Id :"+ id));
		patientRepository.delete(patient);
		
		Map<String, Boolean> response =new HashMap<String, Boolean>();
		response.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
	    Patient patient = patientRepository.findById(patientId)
	            .orElseThrow(() -> new RuntimeException("Patient Not Found with id: " + patientId));
	    return ResponseEntity.ok(patient);
	}


	
}
