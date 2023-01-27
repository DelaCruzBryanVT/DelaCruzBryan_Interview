import { TestBed } from '@angular/core/testing';

import { ServiceEnterpriseService } from './service-enterprise.service';

describe('ServiceEnterpriseService', () => {
  let service: ServiceEnterpriseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceEnterpriseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
