import { TestBed } from '@angular/core/testing';

import { TienenService } from './heros-powers.service';

describe('TienenService', () => {
  let service: TienenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TienenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
