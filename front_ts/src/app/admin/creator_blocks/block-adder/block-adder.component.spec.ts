import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockAdderComponent } from './block-adder.component';

describe('BlockAdderComponent', () => {
  let component: BlockAdderComponent;
  let fixture: ComponentFixture<BlockAdderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlockAdderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlockAdderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
