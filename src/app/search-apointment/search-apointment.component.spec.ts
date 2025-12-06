import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchApointmentComponent } from './search-apointment.component';

describe('SearchApointmentComponent', () => {
  let component: SearchApointmentComponent;
  let fixture: ComponentFixture<SearchApointmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SearchApointmentComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchApointmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
