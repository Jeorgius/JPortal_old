import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockFactoryComponent } from './block-factory.component';

describe('BlockFactoryComponent', () => {
  let component: BlockFactoryComponent;
  let fixture: ComponentFixture<BlockFactoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlockFactoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlockFactoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
