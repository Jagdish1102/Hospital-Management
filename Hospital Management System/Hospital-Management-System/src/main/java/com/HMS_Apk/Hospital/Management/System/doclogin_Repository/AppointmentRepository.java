package com.HMS_Apk.Hospital.Management.System.doclogin_Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
