// import { HttpClient } from '@angular/common/http';
// import { Injectable } from '@angular/core';
// import { Observable } from 'rxjs';
// import { Appointment } from './appointment';

// @Injectable({
//   providedIn: 'root'
// })
// export class AppointmentService {

//   constructor(private httpclint:HttpClient) { }
//     private baseUrl = "http://localhost:8080/api/v2";
//   getAllappointments():Observable<Appointment[]>{
//     return this.httpclint.get<Appointment[]>(`${this.baseUrl}`)
//   }
//   createAppointment(appointment:Appointment):Observable<Appointment>{
//     return this.httpclint.post<Appointment>(`${this.baseUrl}`,appointment);
//   }

// }

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  private baseUrl = 'http://localhost:8080/api/v2/appointments';

  constructor(private http: HttpClient) {}

  // ✅ POST - Create Appointment
  createAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(`${this.baseUrl}/insert`, appointment);
  }

  // ✅ GET - All Appointments
  getAllAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(this.baseUrl);
  }

  // ✅ DELETE - Remove Appointment
  deleteAppointment(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`);
  }

  // ✅ POST - Manage Appointment → Move to Patient
  manageAppointment(id: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/manage/${id}`, {});
  }
}