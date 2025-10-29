import { Component } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-create-appointment',
  templateUrl: './create-appointment.component.html',
  styleUrls: ['./create-appointment.component.css']
})

export class CreateAppointmentComponent {
  appointment: Appointment = new Appointment();

  constructor(
    private appointmentService: AppointmentService,
    private router: Router,
    private Location:Location
  ) {}

  saveAppointments() {
    this.appointmentService.createAppointment(this.appointment).subscribe({
      next: (data) => {
        console.log('Appointment created:', data);
        this.getnavigate();
      },
      error: (err: any) => {
        console.error('Error creating appointment:', err);
      }
    });
  }

  onSubmit() {
    this.saveAppointments();
  }
  getnavigate(){
     this.router.navigate(['/appointmentlist']);  // Optional navigation
  }
  goBack(){
    this.Location.back();
  }
}
