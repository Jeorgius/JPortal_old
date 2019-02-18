import { TestBed, inject } from '@angular/core/testing';

import { CreatorDeterminatorService } from './creator-determinator.service';

describe('CreatorDeterminatorService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CreatorDeterminatorService]
    });
  });

  it('should be created', inject([CreatorDeterminatorService], (service: CreatorDeterminatorService) => {
    expect(service).toBeTruthy();
  }));
});
