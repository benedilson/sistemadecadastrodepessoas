import { TestBed } from '@angular/core/testing';

import { TelefoneDeactivateGuardService } from './telefone-deactivate-guard.service';

describe('TelefoneDeactivateGuardService', () => {
  let service: TelefoneDeactivateGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TelefoneDeactivateGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
