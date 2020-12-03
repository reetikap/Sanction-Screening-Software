import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';

import { ShowtransactionsComponent } from './showtransactions/showtransactions.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadComponent } from './upload/upload.component';

import { from } from 'rxjs';

import { HomeComponent } from './home/home.component';
import { AuthGuard } from './auth.guard';
import { LogoutComponent } from './logout/logout.component';
const routes: Routes = [
  
  {path:'Upload',canActivate:[AuthGuard],component:UploadComponent  },
 
  {path:'showtransactions',canActivate:[AuthGuard],component:ShowtransactionsComponent},
  {path:'registration', component:RegistrationComponent},
  {path:'login',component:LoginComponent},
  {path:'',component:LoginComponent},
  {path:'upload',canActivate:[AuthGuard],component:UploadComponent},
  {path:'home',canActivate:[AuthGuard],component:HomeComponent},
  { path: 'logout',canActivate:[AuthGuard], component: LogoutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
