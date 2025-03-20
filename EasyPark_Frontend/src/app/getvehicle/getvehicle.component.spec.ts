import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetvehicleComponent } from './getvehicle.component';

describe('GetvehicleComponent', () => {
  let component: GetvehicleComponent;
  let fixture: ComponentFixture<GetvehicleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetvehicleComponent]
    });
    fixture = TestBed.createComponent(GetvehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
