import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-insuccess',
  templateUrl: './log-insuccess.component.html',
  styleUrls: ['./log-insuccess.component.css'],
 
})
export class LogInsuccessComponent implements OnInit {
 
  constructor( private _router: Router) { }
 

  ngOnInit(): void {
  }
btnClick(){
  this._router.navigate(['/showtransactions']);

}
}
