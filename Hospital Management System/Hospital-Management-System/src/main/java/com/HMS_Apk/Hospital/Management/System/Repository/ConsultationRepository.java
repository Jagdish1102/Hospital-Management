package com.HMS_Apk.Hospital.Management.System.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {

	List<Consultation> findByPatientId(Long Pid);

	List<Consultation> findByDoctorId(Long Did);
	
}
