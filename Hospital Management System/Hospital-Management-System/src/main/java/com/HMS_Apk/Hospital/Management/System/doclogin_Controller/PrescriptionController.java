package com.HMS_Apk.Hospital.Management.System.doclogin_Controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.HMS_Apk.Hospital.Management.System.Repository.PatientRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Prescription;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.PrescriptionRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin_Service.PrescriptionService;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/prescriptions")
public class PrescriptionController {

	private final PrescriptionService prescriptionService;

	public PrescriptionController(PrescriptionService prescriptionService) {
		this.prescriptionService = prescriptionService;
	}

	@PostMapping("/{patientId}")
	public ResponseEntity<Prescription> addPrescription(@PathVariable Long patientId,
			@RequestBody Prescription prescription) {
		return ResponseEntity.ok(prescriptionService.addPrescription(patientId, prescription));
	}

	@GetMapping("/{patientId}")
	public ResponseEntity<List<Prescription>> getPrescriptions(@PathVariable Long patientId) {
		return ResponseEntity.ok(prescriptionService.getPrescriptions(patientId));
	}

	@DeleteMapping("/patients/{patientId}")
	public ResponseEntity<String> deletePatient(@PathVariable Long patientId) {
		try {
			boolean deleted = prescriptionService.deletePatient(patientId);
			if (deleted) {
				return ResponseEntity.ok("Patient and related prescriptions deleted successfully!");
			} else {
				return ResponseEntity.status(404).body("Patient not found with ID: " + patientId);
			}
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error deleting patient: " + e.getMessage());
		}
	}

	@GetMapping("/today-count")
	public long getTodayPrescriptionCount() {
		return prescriptionService.countTodayPrescriptions();
	}

}
