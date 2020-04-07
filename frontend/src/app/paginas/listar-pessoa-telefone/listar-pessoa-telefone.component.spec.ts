import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPessoaTelefoneComponent } from './listar-pessoa-telefone.component';

describe('ListarPessoaTelefoneComponent', () => {
  let component: ListarPessoaTelefoneComponent;
  let fixture: ComponentFixture<ListarPessoaTelefoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarPessoaTelefoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarPessoaTelefoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
