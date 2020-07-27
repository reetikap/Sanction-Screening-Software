import { Component, OnInit } from '@angular/core';
import  {NgForm} from "@angular/forms";
import { RegistrationService} from "../registration.service";

import {User} from "../users";
import { from } from 'rxjs';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 user= new User();
 msg='';
  constructor(private _service : RegistrationService, private _router: Router) { }
  
    invalidLogin = false
  ngOnInit(): void {
  }
logInUser()
  {
     this._service.authenticate(this.user).subscribe(
       data=>{ 
         console.log("Response Recieved");
         sessionStorage.setItem('username', this.user.emailId)
         this._router.navigate(['/home'])
        },
       error=> {console.log("Exception Occured");
        this.msg="Bad Credentials...Please Enter Valid EmailId and Password";
      }
       
     )
  }

  gotoregistrationPage(){
    this._router.navigate(['/registration'])
  }
}
