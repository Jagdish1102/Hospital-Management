package com.HMS_Apk.Hospital.Management.System.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMS_Apk.Hospital.Management.System.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
