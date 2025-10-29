import { Component ,Input} from '@angular/core';
import { Appointment } from '../appointment';

@Component({
  selector: 'app-patient-list',
  standalone: false,
  templateUrl: './patient-list.component.html',
  styleUrls: ['./patient-list.component.css']
})
export class PatientListComponent {

   @Input() patients: Appointment[] = [];

}
