import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReportService } from '../report-service.service';
import { Patient } from '../patient';

@Component({
  selector: 'app-reports',
  standalone: false,
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css'],
})
export class ReportsComponent implements OnInit {
  reports: any;
  patient!: Patient;

  constructor(
    private route: ActivatedRoute,
    private reportService: ReportService
  ) {}

  ngOnInit(): void {
    const patientId = Number(this.route.snapshot.paramMap.get('patientId'));
    if (patientId) {
      this.loadReports(patientId);
    }
  }

  loadReports(patientId: number) {
    this.reportService.getReportByPatientId(patientId).subscribe(
      (data: any) => {
        this.reports = data;
        this.patient = data.patient; // ✅ Assuming each report has patient details
        console.log('Reports:', this.reports);
      },
      (error) => console.error('Error loading reports:', error)
    );
  }
}
