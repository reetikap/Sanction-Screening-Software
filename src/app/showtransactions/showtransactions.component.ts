import { Component, OnInit } from '@angular/core';
import {TransactionService} from '../transaction.service'
import {MatTableDataSource} from '@angular/material/table';
import { HttpClient } from '@angular/common/http';
import { map} from 'rxjs/operators';
import { Router } from '@angular/router';
import { Transactiontable } from '../transactiontable';
@Component({
  selector: 'app-showtransactions',
  templateUrl: './showtransactions.component.html',
  styleUrls: ['./showtransactions.component.css']
})
export class ShowtransactionsComponent implements OnInit {
 
 
  constructor(private _service :TransactionService ,private router: Router) { }

  users:Transactiontable[];

  

  ngOnInit() {
    this._service.getUsers()
      .subscribe( data => {
        this.users = data;
      });
  };

  

}
