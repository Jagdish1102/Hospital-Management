import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashComponent } from './admin-dash/admin-dash.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { HomeComponent } from './home/home.component';
import { DocdashComponent } from './docdash/docdash.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { AddPrescriptionComponent } from './add-prescription/add-prescription.component';
import { AppointmentFormComponent } from './appointment-form/appointment-form.component';
import { ConsultationComponent } from './consultation/consultation.component';
import { ReportsComponent } from './reports/reports.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'admin', component: AdminDashComponent },
  { path: 'appointmentlist', component: AppointmentComponent },
  { path: 'create-appointment', component: CreateAppointmentComponent },
  { path: 'docdash', component: DocdashComponent },
  { path: 'consultation', component: ConsultationComponent },
  { path: 'add', component: ConsultationComponent },
  { path: 'consultation/:patientId', component: ConsultationComponent },
  { path: 'past-reports/:patientId', component: ReportsComponent },
  { path: 'add-patient', component: AddPatientComponent },
  { path: 'add-prescription', component: AddPrescriptionComponent },
  { path: 'appointment-form', component: AppointmentFormComponent }, // ✅ fixed
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
