import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from "@angular/common/http"
import { User } from './users';
@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor( private _http:HttpClient) { }
  public loginUserFromRemote(user : User):Observable<any>{
 return  this._http.post<any>("http://localhost:8091/login",user)
  }
  public registerUserFromRemote(user: User):Observable<any>{
    return  this._http.post<any>("http://localhost:8091/registeruser",user)
  }
  handleError(error:Response){

  }
  
}
