import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogInsuccessComponent } from './log-insuccess.component';

describe('LogInsuccessComponent', () => {
  let component: LogInsuccessComponent;
  let fixture: ComponentFixture<LogInsuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogInsuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogInsuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
