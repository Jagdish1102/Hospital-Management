import { Component } from '@angular/core';
import { AppointmentService } from '../appointment.service';
import { Observable } from 'rxjs';
import { Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-apointment',
  standalone: false,
  templateUrl: './search-apointment.component.html',
  styleUrl: './search-apointment.component.css'
})
export class SearchApointmentComponent {
  
  keyword = "";
  appointments: any[] = [];
  page = 0;
  size = 5;
  totalPages = 0;
    @Output() results = new EventEmitter<any[]>();

  constructor(private appointmentService: AppointmentService) {}

search() {
    this.appointmentService.searchAppointments(this.keyword, 0, 20)
      .subscribe({
        next: (data) => {
          this.results.emit(data.content);   // <-- SEND DATA TO PARENT
        },
        error: (err) => console.error(err)
      });
  }

  nextPage() {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.search();
    }
  }

  prevPage() {
    if (this.page > 0) {
      this.page--;
      this.search();
    }
  }

}
