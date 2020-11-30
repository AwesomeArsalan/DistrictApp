import { TestBed } from '@angular/core/testing';

import { DistrictService } from './district-service.service';

describe('DistrictServiceService', () => {
  let service: DistrictService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DistrictService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
