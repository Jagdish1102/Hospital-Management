package com.HMS_Apk.Hospital.Management.System.doclogin_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Appointment;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.AppointmentRepository;

@Service
public class AppoinmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Page<Appointment> searchAppointments(String keyword, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return appointmentRepository.searchAppointments(keyword, pageable);
    }
}
