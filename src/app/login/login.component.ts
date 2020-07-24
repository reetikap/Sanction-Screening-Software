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

  ngOnInit(): void {
  }
  logInUser()
  {
     this._service.loginUserFromRemote(this.user).subscribe(
       data=>{ 
         console.log("Response Recieved");
         this._router.navigate(['/logInsuccess'])
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
