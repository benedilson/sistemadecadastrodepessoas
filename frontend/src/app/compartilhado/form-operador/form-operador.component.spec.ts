import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormOperadorComponent } from './form-operador.component';

describe('FormOperadorComponent', () => {
  let component: FormOperadorComponent;
  let fixture: ComponentFixture<FormOperadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormOperadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormOperadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
