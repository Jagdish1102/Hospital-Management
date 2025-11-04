package com.HMS_Apk.Hospital.Management.System.doclogin_Service;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.boot.model.process.internal.UserTypeMutabilityPlanAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.HMS_Apk.Hospital.Management.System.Repository.ConsultationRepository;
import com.HMS_Apk.Hospital.Management.System.Repository.PatientRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Appointment;
import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Consultation;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.DoctorRepository;
import com.HMS_Apk.Hospital.Management.System.entity.Doctor;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Service
public class ConsultationService {
	@Autowired
	private ConsultationRepository consultationRepository;
	@Autowired
	private DoctorRepository doctorRepository;
	@Autowired
	private PatientRepository patientRepository;
	
	
	public Consultation createConsultation(Long Did,Long Pid,Consultation consultation ) {
		Doctor doctor = doctorRepository.findById(Did).orElseThrow(()->new RuntimeException("Doctor Not Found"));
		
		Patient patient=patientRepository.findById(Pid).orElseThrow(()->new RuntimeException("Patient Not Found"));
		
		consultation.setPatient(patient);
		
		consultation.setDoctor(doctor);
		
		consultation.setConsultationDate(LocalDate.now());
		return consultationRepository.save(consultation);
		}

	 public List<Consultation> getConsultationByPatient(Long Pid){
		return consultationRepository.findByPatientId(Pid);
	}
	
	 public List<Consultation> getConsultationByDoctor(Long Did){
		return consultationRepository.findByDoctorId(Did);
	}
	 
	 public List<Consultation> getAllConsultation(){
		 return consultationRepository.findAll();
	 }
	
//	 public ResponseEntity<Consultation> updateConsultation(Long Cid,Consultation updateConsultation){
//		
//		 Consultation consultation = consultationRepository.findById(Cid).orElseThrow(()->new RuntimeException("Consultation Not Found With id :" + Cid));
//		 
////		
//		 	consultation.setPrescription(updateConsultation.getprescription());
//		 	consultation.setNotes(updateConsultation.getNotes());
//		 	consultation.setDiagnosis(updateConsultation.getDiagnosis());
//		 	consultation.setStatus(updateConsultation.getStatus());
//		 	
//		 	
//		 Consultation saved = consultationRepository.save(consultation);
//		 	
//		 
//		 return ResponseEntity.ok(saved);
//	 }
}
