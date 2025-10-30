package com.HMS_Apk.Hospital.Management.System.doclogin_Controller;


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
    public ResponseEntity<Prescription> addPrescription(@PathVariable Long patientId, @RequestBody Prescription prescription) {
        return ResponseEntity.ok(prescriptionService.addPrescription(patientId, prescription));
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<Prescription>> getPrescriptions(@PathVariable Long patientId) {
        return ResponseEntity.ok(prescriptionService.getPrescriptions(patientId));
    }
    
    @DeleteMapping("/prescriptions/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long id) {
        boolean deleted = prescriptionService.deletePrescription(id);
        if (deleted) {
            return ResponseEntity.ok("Prescription deleted successfully!");
        } else {
            return ResponseEntity.status(404).body("Prescription not found with ID: " + id);
        }
    }

    
}
