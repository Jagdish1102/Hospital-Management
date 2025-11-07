
 export class Patient {
  patientId: number = 0;
  name: string = "";
  condition: string = "";      // 👈 matches backend field
  lastVisit: Date = new Date(); // 👈 LocalDateTime in backend → Date in Angular
  status: string = "";
  symtomps:string="";          // 👈 Completed / In Progress
  email :string= "";
  number : string="";
  age: string = "";
  bloodGroup: string = "";      // 👈 renamed from "blood"
  prescription: string = "";
  dose: string = "";
  fees: string = "";
  urgency: string = "";
  address:string ="";
}



