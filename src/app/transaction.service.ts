import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Transactiontable} from './transactiontable'
import { Observable} from 'rxjs';
import { map} from 'rxjs/operators';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable(
  
)
export class TransactionService {

 
  constructor(private http:HttpClient) {}

  private userUrl = "http://localhost:8081/transactions";
	

  public getUsers() {
    return this.http.get<Transactiontable[]>(this.userUrl);
  }


}

