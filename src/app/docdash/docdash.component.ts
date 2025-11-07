import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { ReportService } from '../report-service.service';
import { CommonModule } from '@angular/common';
import { Report } from '../report';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-docdash',
  standalone: false,
  templateUrl: './docdash.component.html',
  styleUrl: './docdash.component.css',
})
export class DocdashComponent {
  constructor(
    private patientService: PatientService,
    private reportService: ReportService,
    private appointmentService: AppointmentService,

    private router: Router
  ) {}

  patients: Patient[] = [];
  reports: Report[] = [];
  appointnments: Appointment[] = [];

  ngOnInit(): void {
    this.getPatients();
    this.getReports();
    this.getappointment();
  }
  getPatients() {
    this.patientService.getPatientList().subscribe((data) => {
      this.patients = data;
    });
  }
  getReports(): void {
    this.reportService.getReportList().subscribe((data) => {
      this.reports = data;
    });
  }

  // ✅ View Patient Method
  viewPatient(patientId: number): void {
    this.router.navigate(['/patients/view', patientId]);
  }

  editPatient(patientId: number): void {
    this.router.navigate(['/patients/edit', patientId]);
  }

  deletePatient(patientId: number): void {
    if (confirm('Are you sure you want to delete this patient?')) {
      this.patientService.deletePatient(patientId).subscribe({
        next: () => {
          console.log('Deleted patient with ID:', patientId);
          
          this.getPatients(); // refresh list
        },
        error: (err) => {
          console.error('Error deleting patient:', err);
          alert('Failed to delete patient. Please try again.');
        },
      });
    }
  }

  getappointment() {
    this.appointmentService.getAllAppointments().subscribe((data) => {
      this.appointnments = data;
    });
  }

  loadAppointments(): void {
    this.appointmentService.getAllAppointments().subscribe((data) => {
      this.appointnments = data;
    });
  }

  // manageAppointment(id: number): void {
  //   this.appointmentService.manageAppointment(id).subscribe({
  //     next: () => {
  //       alert('Appointment moved to Patients successfully!');
  //       this.loadAppointments();
  //       this.getPatients(); // ✅ refresh patient list
  //     },
  //     error: (err) => {
  //       console.error('Error managing appointment:', err);
  //     },
  //   });
  // }


  // manageAppointment(id: number): void {
  // this.appointmentService.manageAppointment(id).subscribe({
  //   next: (newPatient) => {
      
  //     // Remove the appointment from list
  //     this.appointnments = this.appointnments.filter(a => a.id !== id);
  //     alert("Appointment moved to Patients successfully!");

  //     // Add the new patient to the patient list instantly
  //     this.patients.push(newPatient);
  //   },
  //   error: err => {
  //     console.error("Error managing appointment:", err);
  //   }
   // });
 // }



//  manageAppointment(id: number): void {
//   this.appointmentService.manageAppointment(id).subscribe({
//     next: () => {
//       this.getPatients();        // Reload patients from backend
//       this.getappointment();    // Reload appointments from backend
//     },
//     error: (err) => console.error(err)
//   });
manageAppointment(id: number): void {
  this.appointmentService.manageAppointment(id).subscribe({
    next: () => {
      this.getPatients();        // Reload patients from backend
      this.getappointment();    // Reload appointments from backend
    },
    error: (err) => console.error(err)
  });
}



  deleteAppointment(id: number): void {
    this.appointmentService.deleteAppointment(id).subscribe({
      next: () => {
        console.log('Appointment deleted:', id);

        this.getappointment(); // refresh list after deletion
        alert('Appointment deleted successfully!'); // ✅ Show success message
      },
      error: (err) => {
        console.error('Error while deleting appointment:', err);

        alert('Failed to delete the appointment. Please try again.');
      },
    });
  }



   updateStatus(patientId: number, status: string) {
    if (!patientId || !status) return;

    this.patientService.updatePatientStatus(patientId, status).subscribe({
      next: (response) => {
        alert('✅ Status updated successfully!');
      },
      error: (err) => {
        console.error('Error updating status', err);
        alert('❌ Failed to update status!');
      }
    });
  }
}
