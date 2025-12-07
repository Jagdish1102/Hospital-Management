package com.HMS_Apk.Hospital.Management.System.doclogin_Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Prescription;

import jakarta.transaction.Transactional;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByPatientId(Long patientId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Prescription p WHERE p.patient.patientId = :patientId")
    void deleteByPatientId(Long patientId);    
   
    long countByDateIssued(LocalDate dateIssued);  
}