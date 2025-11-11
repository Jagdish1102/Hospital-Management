package com.HMS_Apk.Hospital.Management.System.doclogin_Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.Attribute;
import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HMS_Apk.Hospital.Management.System.Repository.PatientRepository;
import com.HMS_Apk.Hospital.Management.System.doclogin.entity.Appointment;
import com.HMS_Apk.Hospital.Management.System.doclogin_Repository.AppointmentRepository;
import com.HMS_Apk.Hospital.Management.System.entity.Patient;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2/appointments")
public class AppoinmentController {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    // ✅ Constructor Injection (Best Practice)
    public AppoinmentController(AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }

    // ✅ Create Appointment (POST /api/v2/appointments)
    @PostMapping("/insert")
    public Appointment createAppointment(@RequestBody Appointment appointment) {

        // Save appointment first
        Appointment savedApp = appointmentRepository.save(appointment);

        // Create patient record with contact details
        Patient p = new Patient();
        p.setName(appointment.getName());
        p.setEmail(appointment.getEmail());
        p.setNumber(appointment.getNumber());
        p.setAge(appointment.getAge()); // optional
        p.setStatus("New"); // optional
        
        patientRepository.save(p);

        return savedApp;
    }


    // ✅ Get All Appointments (GET /api/v2/appointments)
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    // ✅ Delete Appointment (DELETE /api/v2/appointments/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found with id: " + id));

        appointmentRepository.delete(appointment);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // ✅ Manage Appointment (Move to Patients)
    @PostMapping("/manage/{appointmentId}")
    public ResponseEntity<Patient> manageAppointment(@PathVariable Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        // Create new patient from appointment
        Patient patient = new Patient();
        patient.setName(appointment.getName());
        patient.setAge(appointment.getAge());
        patient.setEmail(appointment.getEmail());
        patient.setNumber(appointment.getNumber());
        patient.setaddress(appointment.getAddress());
        patient.setSymtomps(appointment.getSymtomps());
      // add if Patient has this field
             // add if needed

        // ✅ Save new patient into DB
        Patient savedPatient = patientRepository.save(patient);

        // (Optional) delete appointment after moving
        appointmentRepository.deleteById(appointmentId);

        return ResponseEntity.ok(savedPatient);
    }
    
    

}
