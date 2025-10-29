import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Medicine } from './medicine';

@Injectable({
  providedIn: 'root'
})
export class MedicineService {

  private baseUrl = 'http://localhost:8080/api/v3';  // ✅ backend URL

  constructor(private http: HttpClient) {}

  // 🔍 Search medicines by keyword
  searchMedicines(keyword: string): Observable<Medicine[]> {
    return this.http.get<Medicine[]>(`${this.baseUrl}/search?keyword=${keyword}`);
  }
}
