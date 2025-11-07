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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS_Apk.Hospital.Management.System.Repository.PatientRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.PrescriptionRepository;
import com.HMS_Apk.Hospital.Management.System.entity.Doctor;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

	PatientRepository patientRepository;
	PrescriptionRepository prescriptionRepository;

	public PatientController(PatientRepository paientRepository) {
		super();
		this.patientRepository = paientRepository;
	}

	@PostMapping("/insert")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientRepository.save(patient);

	}

	@GetMapping
	public List<Patient> getAllPatient() {
		return patientRepository.findAll();
	}

	@DeleteMapping("/patient/{patientId}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long patientId)
			throws AttributeNotFoundException {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new AttributeNotFoundException("Appointment Not Found With Id :" + patientId));
		patientRepository.delete(patient);
		prescriptionRepository.deleteByPatientId(patientId);

		patientRepository.deleteById(patientId);

		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/{patientId}")
	public ResponseEntity<Patient> getPatientById(@PathVariable Long patientId) {
		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new RuntimeException("Patient Not Found with id: " + patientId));
		return ResponseEntity.ok(patient);
	}

	@PutMapping("/updateStatus/{patientId}")
	public ResponseEntity<Map<String, String>> updatePatientStatus(@PathVariable Long patientId,
			@RequestBody Map<String, String> request) {

		String status = request.get("status");

		Patient patient = patientRepository.findById(patientId)
				.orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));

		patient.setStatus(status);
		patientRepository.save(patient);

		Map<String, String> response = new HashMap<>();
		response.put("message", "Status updated successfully to: " + status);

		return ResponseEntity.ok(response);
	}

}
