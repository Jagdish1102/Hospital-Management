import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Consultation } from './consultation';

@Injectable({
  providedIn: 'root',
})
export class ConsultationService {
  private baseUrl = 'http://localhost:8080/api/consultations';
  constructor(private http: HttpClient) {}

  getAllConsultation(): Observable<Consultation[]> {
    return this.http.get<Consultation[]>(this.baseUrl);
  }

  getConsultationById(id: number): Observable<Consultation> {
    return this.http.get<Consultation>(`${this.baseUrl}/${id}`);
  }

  createConsultation(consultation: Consultation): Observable<Consultation> {
    return this.http.post<Consultation>(this.baseUrl, consultation);
  }

  getConsultationByPatientId(patientId: number): Observable<Consultation> {
    return this.http.get<Consultation>(
      `${(this.baseUrl)}/patient/${patientId}}`
    );
  }

  getConsultationByDoctorId(doctorId:number):Observable<Consultation>{
return this.http.get<Consultation>(`${this.baseUrl}/doctor/${doctorId}`);
  }
addConsultation(patientId: number, doctorId: number, data: Consultation) {
  return this.http.post<Consultation>(`${this.baseUrl}/add/${patientId}/${doctorId}`, data);
}

  
}
