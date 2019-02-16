import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MusicCreatorComponent } from './music-creator.component';

describe('MusicCreatorComponent', () => {
  let component: MusicCreatorComponent;
  let fixture: ComponentFixture<MusicCreatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MusicCreatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicCreatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
