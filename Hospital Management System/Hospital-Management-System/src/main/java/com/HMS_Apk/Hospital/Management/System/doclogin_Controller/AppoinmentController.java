package com.HMS_Apk.Hospital.Management.System.doclogin_Controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.HMS_Apk.Hospital.Management.System.Repository.PatientRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Appointment;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.AppointmentRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin_Service.AppoinmentService;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/appointments")
public class AppoinmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppoinmentService appointmentService;

    // ➤ Create appointment
    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        Appointment savedApp = appointmentRepository.save(appointment);

        // Create patient record
        Patient p = new Patient();
        p.setName(appointment.getName());
        p.setEmail(appointment.getEmail());
        p.setNumber(appointment.getNumber());
        p.setAge(appointment.getAge());
        p.setStatus("New");

        patientRepository.save(p);

        return savedApp;
    }

    // ➤ Get all appointments
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // ➤ Delete appointment
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointmentRepository.delete(appointment);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }

    // ➤ Count today's appointments
    @GetMapping("/todayAppointments")
    public long countTodayAppointments() {
        LocalDate today = LocalDate.now();
        return appointmentRepository.countByDate(today);
    }

    // ➤ Search with pagination
    @GetMapping("/search")
    public Page<Appointment> searchAppointments(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return appointmentService.searchAppointments(keyword, page, size);
    }
}
