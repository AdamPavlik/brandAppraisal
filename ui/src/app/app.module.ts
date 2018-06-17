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

let routes: Routes = [
  {
    path: '', pathMatch: 'full', component: DashboardComponent
  },
  {
    path: 'login', pathMatch: 'full', component: LoginComponent
  },
  {
    path: 'registration', pathMatch: 'full', component: RegistrationComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent
  ],
  imports: [
    HttpClientModule,
    LayoutModule,
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    AuthenticationModule,
    RouterModule.forRoot(routes)
  ],
  providers: [HttpClientModule, {
    provide: HTTP_INTERCEPTORS,
    useClass: APIInterceptor,
    multi: true },
    LocalStorageService,
    AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
