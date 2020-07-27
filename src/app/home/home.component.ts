import { Component, OnInit } from '@angular/core';
import {RegistrationService } from '../registration.service';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(public loginService:RegistrationService) { }

  ngOnInit(): void {
  }

}
