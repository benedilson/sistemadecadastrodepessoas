import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarOperadorComponent } from './editar-operador.component';

describe('EditarOperadorComponent', () => {
  let component: EditarOperadorComponent;
  let fixture: ComponentFixture<EditarOperadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarOperadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarOperadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
