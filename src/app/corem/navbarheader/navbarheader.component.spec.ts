import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarheaderComponent } from './navbarheader.component';

describe('NavbarheaderComponent', () => {
  let component: NavbarheaderComponent;
  let fixture: ComponentFixture<NavbarheaderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarheaderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarheaderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
