import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarTelefoneComponent } from './listar-telefone.component';

describe('ListarTelefoneComponent', () => {
  let component: ListarTelefoneComponent;
  let fixture: ComponentFixture<ListarTelefoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarTelefoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarTelefoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
