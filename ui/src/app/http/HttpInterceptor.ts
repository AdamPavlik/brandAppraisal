import {Injectable} from '@angular/core';
import {HttpEvent, HttpInterceptor, HttpHandler, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { Router } from '@angular/router';
import { LocalStorageService } from '../commons/localStorage';
import { environment } from '../../environments/environment';
import { isNullOrUndefined } from 'util';

@Injectable()
export class APIInterceptor implements HttpInterceptor {

  constructor(private router: Router,
              private storage: LocalStorageService){

  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const apiReq = req.clone({ url: `http://localhost:8080${req.url}` });
    return next.handle(apiReq);
  }
}
