import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminDashComponent } from './admin-dash/admin-dash.component';
import { AppointmentComponent } from './appointment/appointment.component';
import { CreateAppointmentComponent } from './create-appointment/create-appointment.component';
import { HomeComponent } from './home/home.component';
import { DocdashComponent } from './docdash/docdash.component';
import { AddPatientComponent } from './add-patient/add-patient.component';
import { AddPrescriptionComponent } from './add-prescription/add-prescription.component';
import { ReportsComponent } from './reports/reports.component';
import { PatientListComponent } from './patient-list/patient-list.component';
import { PatientFormComponent } from './patient-form/patient-form.component';
import { PatientDetailsComponent } from './patient-details/patient-details.component';
import { AppointmentFormComponent } from './appointment-form/appointment-form.component';

@NgModule({
  declarations: [
    AppComponent,
    AdminDashComponent,
    AppointmentComponent,
   CreateAppointmentComponent,  // ✅ now valid
    HomeComponent,
    DocdashComponent,
    AddPatientComponent,
    AddPrescriptionComponent,
    ReportsComponent,
    PatientListComponent,
    PatientFormComponent,
    PatientDetailsComponent,
    AppointmentComponent,// ✅ now valid
    AppointmentFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
