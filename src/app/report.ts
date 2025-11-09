export class Report {
  public reportId: number = 0;
  public patientName: string = '';
  public reportType: string = '';
  public description: string = '';
  public status: string = '';
  public reportDate: string = '';

  public patient: {
    patientId: number;
    name: string;
    age: string;
    email: string;
    number: string;
    lastVisit: string;
  } = {
    patientId: 0,
    name: '',
    age: '',
    email: '',
    number: '',
    lastVisit: '',
  };

  public doctor: {
    doctorId: number;
    name: string;
    department: string;
    specialization: string;
    email: string;
  } = {
    doctorId: 0,
    name: '',
    department: '',
    specialization: '',
    email: '',
  };
}
