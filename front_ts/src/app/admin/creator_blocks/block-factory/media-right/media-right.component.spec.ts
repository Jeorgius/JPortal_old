import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MediaRightComponent } from './media-right.component';

describe('MediaRightComponent', () => {
  let component: MediaRightComponent;
  let fixture: ComponentFixture<MediaRightComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MediaRightComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MediaRightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
