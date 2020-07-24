import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogInsuccessComponent } from './log-insuccess/log-insuccess.component';
import { ShowtransactionsComponent } from './showtransactions/showtransactions.component';
import { RegistrationComponent } from './registration/registration.component';
import { UploadComponent } from './upload/upload.component';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'logInsuccess',component:LogInsuccessComponent},
  {path:'showtransactions',component:ShowtransactionsComponent},
  {path:'registration', component:RegistrationComponent},
  {path:'login',component:LoginComponent},
  {path:'upload',component:UploadComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
