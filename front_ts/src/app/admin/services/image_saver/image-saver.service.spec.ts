import { TestBed } from '@angular/core/testing';

import { ImageSaverService } from './image-saver.service';

describe('ImageSaverService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ImageSaverService = TestBed.get(ImageSaverService);
    expect(service).toBeTruthy();
  });
});
