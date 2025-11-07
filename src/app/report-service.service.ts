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
  getReportByPatientId(patientId: number): Observable<any> {
    return this.http.get(
      `http://localhost:8080/api/reports/patient/${patientId}`
    );
  }
}
