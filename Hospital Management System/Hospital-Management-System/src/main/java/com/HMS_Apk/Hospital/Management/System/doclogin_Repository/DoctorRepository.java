package com.HMS_Apk.Hospital.Management.System.doclogin_Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS_Apk.Hospital.Management.System.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	List<Doctor> findAll();

	

	
}
