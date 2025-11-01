package com.HMS_Apk.Hospital.Management.System.doclogin_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Consultation;
import com.HMS_Apk.Hospital.Management.System.doclogin_Service.ConsultationService;

@RestController
@RequestMapping("/api/consultations")
@CrossOrigin(origins = "*")
public class ConsultationController {
	
	
	@Autowired
	private ConsultationService consultationService;
	
	
	@PostMapping("/{id}/{doctorid}")
	public Consultation addConsultation(@PathVariable Long id,@PathVariable Long doctorid,@RequestBody Consultation consultation) {
		
		
		return consultationService.createConsultation(id, doctorid, consultation);
	}
	
	@GetMapping("/patient/{id}")
	public List<Consultation> getByPatient(@PathVariable Long id){
		return consultationService.getConsultationByPatient(id);
	}
	
	 
	@GetMapping("/doctor/{doctorid}")
	public List<Consultation> getByDoctor(@PathVariable Long doctorid){
		return consultationService.getConsultationByDoctor(doctorid);
	}
	
}



