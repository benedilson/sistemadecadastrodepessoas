import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarOperadorComponent } from './listar-operador.component';

describe('ListarOperadorComponent', () => {
  let component: ListarOperadorComponent;
  let fixture: ComponentFixture<ListarOperadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarOperadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarOperadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
