import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InserirTelefoneComponent } from './inserir-telefone.component';

describe('InserirTelefoneComponent', () => {
  let component: InserirTelefoneComponent;
  let fixture: ComponentFixture<InserirTelefoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InserirTelefoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InserirTelefoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
