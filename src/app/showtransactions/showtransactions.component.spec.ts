import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowtransactionsComponent } from './showtransactions.component';

describe('ShowtransactionsComponent', () => {
  let component: ShowtransactionsComponent;
  let fixture: ComponentFixture<ShowtransactionsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowtransactionsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowtransactionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
