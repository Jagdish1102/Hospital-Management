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

import com.HMS_Apk.Hospital.Management.System.Service.DoctorService;
import com.HMS_Apk.Hospital.Management.System.entity.Doctor;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/add")
	public Doctor createDoctor(@RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

	@GetMapping
	public List<Doctor> getAllDoctors(){
		return doctorService.getAllDoctors();
	}
	
	@GetMapping("/{doctorid}")
	public Doctor getDoctorById(@PathVariable Long doctorid) {
		return doctorService.getDoctorById(doctorid);
	}
	
	@DeleteMapping("/doctors/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteDoctor(@PathVariable long doctorid) throws AttributeNotFoundException {
		return  doctorService.deleteDoctor(doctorid);
	
	}

}
