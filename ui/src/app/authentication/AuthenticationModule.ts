import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { MaterialModule } from '../commons/matereal/materialModule';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { LoginService } from './login/service/loginService';
import { AuthService } from '../auth/AuthService';

@NgModule({
  declarations: [
    LoginComponent,
    RegistrationComponent
  ],
  exports: [
    MaterialModule
  ],
  imports: [
    MaterialModule,
    RouterModule
  ],
  providers: [LoginService, AuthService]
})
export class AuthenticationModule {
}
