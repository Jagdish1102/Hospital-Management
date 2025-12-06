import { Component } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Appointment } from '../appointment';
import { SearchApointmentComponent } from '../search-apointment/search-apointment.component';

@Component({
  selector: 'app-appointment',
  standalone: false,
  templateUrl: './appointment.component.html',
  styleUrl: './appointment.component.css',
})
export class AppointmentComponent {
  appointnments: Appointment[] = [];
   patients: Appointment[] = []; 
  constructor(private appointmentService: AppointmentService) {}
  ngOnInit(): void {
    this.getappointment();
  }
  getappointment() {
    this.appointmentService.getAllAppointments().subscribe((data) => {
      this.appointnments = data;
    });
  }

  delete(id: number): void {
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



  manageAppointment(id: number) {
    // Find appointment
    const index = this.appointnments.findIndex(app => app.appointmentId === id);
    if (index > -1) {
      const patient = this.appointnments[index];

      // Change status to "In Progress"
      patient.status = 'In Progress';

      // Push to patient list
      this.patients.push(patient);

      // Remove from appointment list
      this.appointnments.splice(index, 1);
    }
  }

deleteAppointment(appointmentId: number) {
    this.appointnments = this.appointnments.filter(app => app.appointmentId !== appointmentId);
  }


updateList(newData: any[]) {
  this.appointnments = newData;
}


  
}


