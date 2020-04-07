import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditarTelefoneComponent } from './editar-telefone.component';

describe('EditarTelefoneComponent', () => {
  let component: EditarTelefoneComponent;
  let fixture: ComponentFixture<EditarTelefoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditarTelefoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditarTelefoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
