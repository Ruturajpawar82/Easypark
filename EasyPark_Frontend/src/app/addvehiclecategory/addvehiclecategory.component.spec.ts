import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddvehiclecategoryComponent } from './addvehiclecategory.component';

describe('AddvehiclecategoryComponent', () => {
  let component: AddvehiclecategoryComponent;
  let fixture: ComponentFixture<AddvehiclecategoryComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddvehiclecategoryComponent]
    });
    fixture = TestBed.createComponent(AddvehiclecategoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
