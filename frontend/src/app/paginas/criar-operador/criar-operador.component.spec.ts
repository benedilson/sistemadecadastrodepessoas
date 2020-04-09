import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarOperadorComponent } from './criar-operador.component';

describe('CriarOperadorComponent', () => {
  let component: CriarOperadorComponent;
  let fixture: ComponentFixture<CriarOperadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarOperadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarOperadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
