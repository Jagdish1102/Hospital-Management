import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';
import { ReportService } from '../report-service.service';
import { CommonModule } from '@angular/common';
import { Report } from '../report';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';
import { PrescriptionService } from '../prescription.service';
import { Prescription } from '../prescription';

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
    private prescriptionService: PrescriptionService,
    private router: Router
  ) {}

  patients: Patient[] = [];
  reports: Report[] = [];
  appointnments: Appointment[] = [];
  pendingReportsCount: number = 0;
  todayPrescriptionCount: number = 0;

prescriptions:Prescription[]=[];
  
  ngOnInit(): void {
    this.getPatients();
    this.getReports();
    this.getappointment();
    this.getTodayAppointments();
    this.getPendingReports();
    this.getTodayPrescriptionCount();

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

  getTodayAppointments(): void {
    this.appointmentService.getAllAppointments().subscribe({
      next: (data: Appointment[]) => {
        this.appointnments = data;
        console.log('Appointments:', this.appointnments);
      },
      error: (err) => console.error(err),
    });
  }
  countTodayPatients(): void {
    this.patientService.countTodayPatients().subscribe({
      next: (data: Patient[]) => {
        this.patients = data;
        console.log('patients:', this.patients);
      },
      error: (err) => console.error(err),
    });
  }

getTodayPrescriptionCount(): void {
  this.prescriptionService.getTodayPrescriptions().subscribe({
    next: (count) => {
      this.todayPrescriptionCount = count;
    },
    error: (err) => {
      console.error("Error fetching today's prescriptions", err);
      this.todayPrescriptionCount = 0;
    }
  });
}


  getPendingReports(): void {
    this.reportService.getPendingReports().subscribe({
      next: (count: number) => {
        this.pendingReportsCount = count; // directly set
      },
      error: () => (this.pendingReportsCount = 0),
    });
  }

  manageAppointment(id: number): void {
    this.appointmentService.manageAppointment(id).subscribe({
      next: () => {
        this.getPatients(); // Reload patients from backend
        this.getappointment(); // Reload appointments from backend
      },
      error: (err) => console.error(err),
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
      },
    });
  }

  // ✔ FIXED
}
