import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from "@angular/common/http"
import { User } from './users';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor( private _http:HttpClient) { }
  authenticate(user : User):Observable<any>{
 return  this._http.post<any>("http://localhost:8102/rest/sanctions/login",user)
  }
  public registerUserFromRemote(user: User):Observable<any>{
    return  this._http.post<any>("http://localhost:8102/rest/sanctions/registeruser",user)
  }
  handleError(error:Response){

  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
