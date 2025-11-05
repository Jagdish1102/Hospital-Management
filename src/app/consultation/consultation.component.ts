import { Component, OnInit } from '@angular/core';
import { Consultation } from '../consultation';
import { ConsultationService } from '../consultation.service';
import { Patient } from '../patient';
import { PatientService } from '../patient.service';
import { Location } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-consultation',
  standalone: false,
  templateUrl: './consultation.component.html',
  styleUrls: ['./consultation.component.css'],
})
export class ConsultationComponent implements OnInit {
  consultations: Consultation[] = [];
  patient: any; // ✅ single patient
  email!: string;
  number!: string;
  address!: string;

  constructor(
    private route: ActivatedRoute,
    private consultationService: ConsultationService,
    private patientService: PatientService,
    private location: Location,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('patientId'); // ✅ get ID from URL
   if(id){
      this.loadPatientById(Number(id));
   }

    this.getConsultations();
    this.startTimer();
  }

  getConsultations(): void {
    this.consultationService
      .getAllConsultation()
      .subscribe((data) => (this.consultations = data));
  }

 loadPatientById(id: number) {
  this.http.get(`http://localhost:8080/api/v1/patient/${id}`).subscribe(
    (data: any) => {
      this.patient = data;
      console.log("patient data =>",this.patient);
    },
    (error) => console.log(error)
  );
}


  goBack() {
    this.location.back();
  }

  timer: string = '00:00:00';
  private seconds = 0;
  private interval: any;

  startTimer() {
    this.interval = setInterval(() => {
      this.seconds++;

      const hrs = Math.floor(this.seconds / 3600);
      const mins = Math.floor((this.seconds % 3600) / 60);
      const secs = this.seconds % 60;

      this.timer =
        `${hrs.toString().padStart(2, '0')}:` +
        `${mins.toString().padStart(2, '0')}:` +
        `${secs.toString().padStart(2, '0')}`;
    }, 1000);
  }

  ngOnDestroy() {
    if (this.interval) {
      clearInterval(this.interval);
    }
  }
}
