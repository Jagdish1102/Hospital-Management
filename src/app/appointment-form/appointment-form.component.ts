import { Component } from '@angular/core';
import { Appointment } from '../appointment';
import { AppointmentService } from '../appointment.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-appointment-form',
    standalone: false,
  templateUrl: './appointment-form.component.html',
  styleUrls: ['./appointment-form.component.css']
})
export class AppointmentFormComponent {
  appointment: Appointment = new Appointment();
  redirectTo: string = '';

  constructor(
    private appointmentService: AppointmentService,
    private router: Router,
    private route: ActivatedRoute,
    private location: Location
  ) {}

  ngOnInit() {
    this.redirectTo = this.route.snapshot.queryParamMap.get('from') || 'home';
  }

  onSubmit() {
    console.log('Submit clicked', this.appointment);

    this.appointmentService.createAppointment(this.appointment).subscribe({
      next: (data) => {
        console.log('✅ Appointment saved:', data);
        this.appointment = new Appointment();
        alert('Appointment created successfully!');

        if (this.redirectTo === 'docdash') {
          this.router.navigate(['/docdash']);
        } else {
          this.router.navigate(['/home']);
        }
      },
      error: (err) => {
        console.error('❌ Error saving appointment:', err);
        alert('Failed to create appointment.');
      },
    });
  }
}
