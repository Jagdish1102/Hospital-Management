package com.HMS_Apk.Hospital.Management.System.doclogin_Service;


import com.HMS_Apk.Hospital.Management.System.Repository.PatientRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Prescription;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.PrescriptionRepository;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final PatientRepository patientRepository;

    public PrescriptionService(PrescriptionRepository prescriptionRepository, PatientRepository patientRepository) {
        this.prescriptionRepository = prescriptionRepository;
        this.patientRepository = patientRepository;
    }

    // Add Prescription
    public Prescription addPrescription(Long patientId, Prescription prescription) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with ID: " + patientId));

        prescription.setPatient(patient);
        return prescriptionRepository.save(prescription);
    }

    // Get Prescriptions by Patient ID
    public List<Prescription> getPrescriptions(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }
    
    public boolean deletePrescription(Long id) {
        if (prescriptionRepository.existsById(id)) {
            prescriptionRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Transactional
    public boolean deletePatient(Long patientId) {
        // Check if the patient exists
        if (patientRepository.existsById(patientId)) {

            // Step 1: Delete all prescriptions linked to this patient
            prescriptionRepository.deleteByPatientId(patientId);

            // Step 2: Delete the patient itself
            patientRepository.deleteById(patientId);

            return true;
        } else {
            return false; // Patient not found
        }
    }

}