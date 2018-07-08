import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { AuthService } from './auth/AuthService';
import { AuthenticationModule } from './authentication/AuthenticationModule';
import { LoginComponent } from './authentication/login/login.component';
import { RegistrationComponent } from './authentication/registration/registration.component';
import { LocalStorageService } from './commons/localStorage';
import { DashboardComponent } from './dashboard/dashboard.component';
import { APIInterceptor } from './http/HttpInterceptor';
import { LayoutModule } from './layout/LayoutModule';
import { CurrentUserService } from './auth/CurrentUserService';
import { FlexLayoutModule } from '@angular/flex-layout';
import { AuthCanActivate } from './auth/guardServices/AuthCanActivate';
import { SnotifyModule, SnotifyService, ToastDefaults } from 'ng-snotify';
import { AuthNotAuthenticationGuard } from './auth/guardServices/AuthNotAuthenticationGuard';

let routes: Routes = [
  {
    path: '', pathMatch: 'full', component: DashboardComponent
  },
  {
    path: 'login', pathMatch: 'full', component: LoginComponent, canActivate: [AuthNotAuthenticationGuard]
  },
  {
    path: 'registration', pathMatch: 'full', component: RegistrationComponent, canActivate: [AuthNotAuthenticationGuard]
  },
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
  ],
  imports: [
    FlexLayoutModule,
    HttpClientModule,
    LayoutModule,
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AuthenticationModule,
    SnotifyModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
  ],
  providers: [HttpClientModule, {
    provide: HTTP_INTERCEPTORS,
    useClass: APIInterceptor,
    multi: true },
    CurrentUserService,
    LocalStorageService,
    AuthService,
    AuthCanActivate,
    AuthNotAuthenticationGuard,
    { provide: 'SnotifyToastConfig', useValue: ToastDefaults},
    SnotifyService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
