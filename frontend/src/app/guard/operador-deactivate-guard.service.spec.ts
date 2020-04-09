import { TestBed } from '@angular/core/testing';

import { OperadorDeactivateGuardService } from './operador-deactivate-guard.service';

describe('OperadorDeactivateGuardService', () => {
  let service: OperadorDeactivateGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OperadorDeactivateGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
