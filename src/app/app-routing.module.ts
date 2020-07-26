import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogInsuccessComponent } from './log-insuccess/log-insuccess.component';
import { ShowtransactionsComponent } from './showtransactions/showtransactions.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadComponent } from './upload/upload.component';
import {CoremModule} from './corem/corem.module';
import { from } from 'rxjs';
import { NavbarComponent } from './navbar/navbar.component';
import { HomeComponent } from './home/home.component';
const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'log-insuccess',
  component:LogInsuccessComponent, 
  children:[{
    path:'',
    component:LogInsuccessComponent,
  },
  {path:'home',
  component:HomeComponent
},
  {path:'Upload',component:UploadComponent}]},
  {path:'logInsuccess',component:LogInsuccessComponent},
  {path:'showtransactions',component:ShowtransactionsComponent},
  {path:'registration', component:RegistrationComponent},
  {path:'login',component:LoginComponent},
  {path:'upload',component:UploadComponent},
  {path:'home',component:HomeComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
