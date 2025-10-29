import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Prescription } from './prescription';

@Injectable({
  providedIn: 'root'
})
export class PrescriptionService {
  private baseURL = 'http://localhost:8080/api/v1/prescriptions';

  constructor(private http: HttpClient) {}

  // ✅ Add prescription
  addPrescription(patientId: number, prescription: Prescription): Observable<Prescription> {
    return this.http.post<Prescription>(`${this.baseURL}/${patientId}`, prescription);
  }

  // ✅ Get prescriptions for a patient
  getPrescriptions(patientId: number): Observable<Prescription[]> {
    return this.http.get<Prescription[]>(`${this.baseURL}/${patientId}`);
  }

DeletePrescriptions(id: number): Observable<any> {
  return this.http.delete(`${this.baseURL}/prescriptions/${id}`, { responseType: 'text' });
}

}
