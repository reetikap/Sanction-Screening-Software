import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from "@angular/common/http";

import { ShowtransactionsComponent } from './showtransactions/showtransactions.component';
import { UploadComponent } from './upload/upload.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {TransactionService} from './transaction.service'
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule} from '@angular/material/button';
import { MatIconModule} from '@angular/material/icon';
import { MatButtonToggleModule} from '@angular/material/button-toggle';
import { MatAutocompleteModule} from '@angular/material/autocomplete';
import { MatTooltipModule} from '@angular/material/tooltip';
import {MatTableModule} from '@angular/material/table'

import { HomeComponent } from './home/home.component';
import {AuthGuard} from './auth.guard';
import { LogoutComponent } from './logout/logout.component';



@NgModule({
  declarations: [
    AppComponent,
  
    LoginComponent,
    RegistrationComponent,
   
    ShowtransactionsComponent,
    UploadComponent,
 
    HomeComponent,
    LogoutComponent,
    
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatAutocompleteModule,
    MatButtonToggleModule,
    
    MatTooltipModule,
   
  
    

  
  ],
  
  providers: [AuthGuard, TransactionService],
  bootstrap: [AppComponent],

})
export class AppModule { }
