import { Component } from '@angular/core';
import { PatientService } from '../patient.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-admin-dash',
  standalone: false,
  templateUrl: './admin-dash.component.html',
  styleUrl: './admin-dash.component.css',
})
export class AdminDashComponent {
  patients: Patient[] = [];
  constructor(private patientService: PatientService) {}
  ngOnInit(): void {
    this.getPAtients();
  }
  getPAtients() {
    this.patientService.getPatientList().subscribe((data) => {
      this.patients = data;
    });
  }
  delete(id: number): void {
    this.patientService.deletePatient(id).subscribe({
      next: () => {
        console.log('Deleted', id);
        this.getPAtients();
      },
      error: (err) => {
        console.error('Error while deleting appointment:', err);

        alert('Failed to delete the appointment. Please try again.');
      },
    });
  }
}
