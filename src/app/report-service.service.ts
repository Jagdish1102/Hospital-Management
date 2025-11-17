import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Report } from './report';
 

@Injectable({
  providedIn: 'root',
})
export class ReportService {
  private baseURL = 'http://localhost:8080/api/reports';

  constructor(private http: HttpClient) {}

  getReportList(): Observable<Report[]> {
    return this.http.get<Report[]>(this.baseURL);
  }

  // getReportByPatientId(patientId:number):Observable<Report>{
  //   return this.http.get<Report>(`${this.baseURL}/patient/${patientId}`);
  // }
 countReportsByDoctorId(doctorId: number): Observable<number> {
  return this.http.get<number>(`${this.baseURL}/doctor/${doctorId}/count`);
}

getPendingReports(): Observable<number> {
  return this.http.get<number>(`${this.baseURL}/pendingReports`);
}

}
