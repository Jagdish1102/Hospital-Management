package com.HMS_Apk.Hospital.Management.System.doclogin_Repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

	long countByDate(LocalDate date);

	@Query("SELECT a FROM Appointment a " +
		       "WHERE CAST(a.appointmentId AS string) LIKE CONCAT('%', :keyword, '%') " +
		       "OR LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
		       "OR LOWER(a.number) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
		       "OR LOWER(a.status) LIKE LOWER(CONCAT('%', :keyword, '%'))")
		Page<Appointment> searchAppointments(@Param("keyword") String keyword, Pageable pageable);
}
