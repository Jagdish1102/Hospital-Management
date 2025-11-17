import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from './patient';

@Injectable({
  providedIn: 'root',
})
export class PatientService {
  constructor(private httpClient: HttpClient) {}
  private baseUrl = 'http://localhost:8080/api/v1/patient';
  getPatientList(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(`${this.baseUrl}`);
  }

 deletePatient(patientId: number): Observable<any> {
  return this.httpClient.delete(`${this.baseUrl}/${patientId}`);
}
  
  getPatientById(patientId: number): Observable<Patient> {
    return this.httpClient.get<Patient>(`${this.baseUrl}/${patientId}`);
  }

  
  updatePatientStatus(patientId: number, status: string): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}/updateStatus/${patientId}`, { status } ,{ responseType: 'text' });
  }

   countTodayPatients(): Observable<Patient[]> {
    return this.httpClient.get<Patient[]>(`${this.baseUrl}/patients`);
  }

}
