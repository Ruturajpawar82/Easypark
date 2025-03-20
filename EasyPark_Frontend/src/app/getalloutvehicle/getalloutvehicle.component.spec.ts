import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetalloutvehicleComponent } from './getalloutvehicle.component';

describe('GetalloutvehicleComponent', () => {
  let component: GetalloutvehicleComponent;
  let fixture: ComponentFixture<GetalloutvehicleComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetalloutvehicleComponent]
    });
    fixture = TestBed.createComponent(GetalloutvehicleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
