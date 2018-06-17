import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class LayoutService {

  constructor(private http: HttpClient) {

  }

  getUser(): Observable<any>{
    return this.http.get('/');
  }

}


export interface User {
  id: number,
  firstName: string
}
