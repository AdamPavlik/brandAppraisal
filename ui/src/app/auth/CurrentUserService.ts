import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './AuthService';
import { LocalStorageService } from '../commons/localStorage';
import { environment } from '../../environments/environment';
import { isNullOrUndefined } from 'util';

@Injectable()
export class CurrentUserService {

  constructor(private router: Router,
              private auth: AuthService,
              private storage: LocalStorageService) {
  }

  public fetchDetails(): Observable<any> {
    return null;
  }

  public isAuthenticated(): boolean {
    return this.storage.get(environment.TOKEN_NAME) !== null;
  }

}
