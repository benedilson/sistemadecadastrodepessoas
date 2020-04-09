import { TestBed } from '@angular/core/testing';

import { PessoaDeactivateGuardService } from './pessoa-deactivate-guard.service';

describe('PessoaDeactivateGuardService', () => {
  let service: PessoaDeactivateGuardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PessoaDeactivateGuardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
