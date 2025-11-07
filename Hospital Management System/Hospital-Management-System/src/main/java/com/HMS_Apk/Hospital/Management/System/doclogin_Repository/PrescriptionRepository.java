package com.HMS_Apk.Hospital.Management.System.doclogin_Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByPatientId(Long patientId);

	void deleteByPatientId(Long patientId);
    
   

}