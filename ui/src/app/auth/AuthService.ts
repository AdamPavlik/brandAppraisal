import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { map } from 'rxjs/operator/map';
import { environment } from '../../environments/environment';
import { LocalStorageService } from '../commons/localStorage';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient,
              private storage: LocalStorageService
  ) {

  }

  login(login: string, password: string) : Observable<Token> {
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json; charset=utf-8');
    headers = headers.append('Authorization', environment.OAUTH2_BASIC);
    let url = '/oauth/token?grant_type=password&username=' + login + '&password=' + password;
    return this.http.post<Token>(url, null,{headers: headers});
  }

  checkToken(token: string): Observable<TokenAvailable>{
    let headers = new HttpHeaders();
    headers = headers.append('Content-Type', 'application/json; charset=utf-8');
    headers = headers.append('Authorization', "Basic YWRtaW46YWRtaW4=");
    let url = '/oauth/check_token?token=' + token;
    return this.http.get<TokenAvailable>(url,{headers: headers});
  }

  registration(user: User): Observable<User>{
    let url = '/public/registration';
    return this.http.post<User>(url, user);
  }

  logout(){
    this.storage.remove(environment.TOKEN_NAME);
    window.location.href = '/';
  }

}

export interface TokenAvailable{
  exp: number;
  user_name: string;
  authorities: Array<string>,
  client_id: string,
  scope: Array<string>

}

export interface Token {
  access_token: string;
  token_type: string;
  expires_in: number;
  scope: string
}

export interface User {
  id: string
  firstName: string,
  secondName: string,
  phoneNumber: string,
  email: string,
  password: string
}
