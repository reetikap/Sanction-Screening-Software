import { Component, OnInit } from '@angular/core';
import  {NgForm} from "@angular/forms";
import {User} from "../users";
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
 user=new User();
 msg="";
  constructor(private _service : RegistrationService, private _router: Router) { }


  ngOnInit(): void {
  }
  registrationUser(){
    this._service.registerUserFromRemote(this.user).subscribe(
data=>{
  console.log("Response Recieved");
  this.msg="Registration Sucessful";
  this._router.navigate(['/login'])
},
error=>{
  console.log("Exception Occured");
  this.msg="Error Occured";
  ;
  
}

    )
  }
  gotoLoginPage(){
    this._router.navigate(['/login'])
  }
}
