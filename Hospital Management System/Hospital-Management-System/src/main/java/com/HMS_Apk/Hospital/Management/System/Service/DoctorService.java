package com.HMS_Apk.Hospital.Management.System.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.DoctorRepository;
import com.HMS_Apk.Hospital.Management.System.entity.Doctor;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

import jakarta.persistence.Id;

@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;
	

	public Doctor addDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);	
	}
	

	public List<Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}
	
	
	public Doctor getDoctorById(@PathVariable Long doctorid) {
		return doctorRepository.findById(doctorid).orElseThrow(()->new RuntimeException("Doctor Not Found With Id:" + doctorid));
		
	}
	

	public ResponseEntity<Map<String,Boolean>>deleteDoctor(@PathVariable long doctorid) throws AttributeNotFoundException{
		Doctor doctor = doctorRepository.findById(doctorid).orElseThrow(()->new AttributeNotFoundException("Appointment Not Found With Id :"+ doctorid));
		doctorRepository.delete(doctor);
		
		Map<String, Boolean> response =new HashMap<String, Boolean>();
		response.put("Deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
