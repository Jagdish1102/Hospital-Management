import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Prescription } from '../prescription';
import { PrescriptionService } from '../prescription.service';

@Component({
  selector: 'app-prescription',
  standalone: false,
  templateUrl: './add-prescription.component.html',
  styleUrls: ['./add-prescription.component.css']   // ✅ FIXED here
})
export class AddPrescriptionComponent {
  patientId!: number;
  prescription: Prescription = new Prescription();
  prescriptions: Prescription[] = [];
  successMessage: string = '';

  constructor(
    private prescriptionService: PrescriptionService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.patientId = +this.route.snapshot.paramMap.get('id')!;
    this.loadPrescriptions();
  }

  loadPrescriptions() {
    this.prescriptionService.getPrescriptions(this.patientId).subscribe(data => {
      this.prescriptions = data;
    });
  }

  onSubmit() {
    this.prescriptionService.addPrescription(this.patientId, this.prescription).subscribe(
      data => {
        this.successMessage = 'Prescription added successfully!';
        this.prescription = new Prescription(); // reset form
        this.loadPrescriptions(); // reload list
      },
      error => {
        console.error('Error adding prescription:', error);
      }
    );
  }
}
